# 理解`Java中String.intern`方法

[toc]

## 一、背景

在阅读《Effective Java》第81条的时候，看到上面写下了这么一段程序，说是模拟了`String.intern`的行为：

```java
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    private static String intern(String s){
        String previousValue = map.putIfAbsent(s, s);
        return previousValue == null? s : previousValue;
    }
```

顿时对`String.intern`方法产生了好奇，于是翻开了这个方法对源码注释。

## 二、`String.intern`方法的源码注释

该方法的源码注释如下：

```java
    /**
     * Returns a canonical representation for the string object.
     * 返回一个字符串对象的权威的代表。
     * <p>
     * A pool of strings, initially empty, is maintained privately by the
     * class {@code String}.
     * 一个字符串池子，初始时空的，这个池子是被String类的私有方法维护着。
     * <p>
     * When the intern method is invoked, if the pool already contains a
     * string equal to this {@code String} object as determined by
     * the {@link #equals(Object)} method, then the string from the pool is
     * returned. Otherwise, this {@code String} object is added to the
     * pool and a reference to this {@code String} object is returned.
     * 当intern方法被调用的时候，根据equals(Object)方法判断，如果这个池子里面已经有一个相等的字符串，
     * 那么这个池子中的这个字符串将会返回。否则，这个对象讲会被添加到池子里面，并且把这个对象的引用返回。
     * <p>
     * It follows that for any two strings {@code s} and {@code t},
     * {@code s.intern() == t.intern()} is {@code true}
     * if and only if {@code s.equals(t)} is {@code true}.
     * 对于任何的两个字符串（s和t），都遵循如下规则：当且仅仅当s.equals(t)为true的时候，
     * s.intern()== t.intern() 也为true
     * <p>
     * All literal strings and string-valued constant expressions are
     * interned. String literals are defined in section 3.10.5 of the
     * <cite>The Java&trade; Language Specification</cite>.
     * 所有文本字符串和字符串值常量表达式都是内部连接的。
     *
     * @return  a string that has the same contents as this string, but is
     *          guaranteed to be from a pool of unique strings.
     *          一个有相同内容的字符串，但是保证它是来自于字符串池中唯一的那个
     * @jls 3.10.5 String Literals
     */
    public native String intern();
```

## 三、字符串字面量（String literals）

[The Java&trade; Language Specification 3.10.5章节部分内容如下：](https://docs.oracle.com/javase/specs/jls/se13/html/jls-3.html#jls-3.10.5)

> A *string literal* consists of zero or more characters enclosed in double quotes.Characters may be represented by escape sequences
>
> 字符串字面量是由闭合在双引号中的零个或多个字符组成。字符可以用转义序列表示。
>
> A string literal is always of type `String`.
>
> 一个字符串字面量总是一个字符串类型。
>
> It is a compile-time error for a line terminator to appear after the opening " and before the closing matching ".
>
> 行结束符出现在开始"之后和结束匹配"之前是一个编译错误。
>
> *A long string literal can always be broken up into shorter pieces and written as a (possibly parenthesized) expression using the string concatenation operator* `+` 。
>
> 一个长的字符串字面量总是能够分成短的片段，并且使用字符串连接符‘+’写成一个表达式。
>
> Moreover, a string literal always refers to the same instance of class String.
>
> 而且，字符串文字总是引用类string的相同实例

```java
""                    // the empty string  一个空字符串
"\""                  // a string containing " alone  单独一个 "字符
"This is a string"    // a string containing 16 characters  一个包含 16个字符的字符串
"This is a " +        // actually a string-valued constant expression,  
    "two-line string"    // formed from two string literals    实际上是由两个字符串字面量组成的字
                         // 符串常量
```

典型的案例：

```java
package testPackage;
class Test {
    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";
        System.out.println(hello == "Hello");
        System.out.println(Other.hello == hello);
        System.out.println(other.Other.hello == hello);
        System.out.println(hello == ("Hel"+"lo"));
        System.out.println(hello == ("Hel"+lo));
        System.out.println(hello == ("Hel"+lo).intern());
    }
}
class Other { static String hello = "Hello"; }
```

```java
package other;
public class Other { public static String hello = "Hello"; }
```

运行结果：

```java
true
true
true
true
false
true
```

这个案例阐述了六点：

- 在同一个类和包下面的字符串字面量代表着相同字符串对象的引用；

  > *String literals in the same class and package represent references to the same* `String` *object* .

-  在不同的类相同的包下的字符串字面量代表着相同的字符串对象的引用；

  > *String literals in different classes in the same package represent references to the same* `String` *object.*

- 在不同的类不同的包下的字符串字面量同样代表着相同的字符串对象的引用；

  > *String literals in different classes in different packages likewise represent references to the same* `String` *object.*

- **从常量表达式连接而来的字符串在编译时计算，然后将它们当作字面量处理**。

  > *Strings concatenated from constant expressions (*[§15.28](https://docs.oracle.com/javase/specs/jls/se13/html/jls-15.html#jls-15.28)*) are computed at compile time and then treated as if they were literals.*

- **在运行时通过连接计算的字符串是新创建的，因此是不同的**。

  > *Strings computed by concatenation at run time are newly created and therefore distinct.*

- 显式地将计算得到的字符串插入到另一个字符串中，其结果是与任何具有相同内容的预先存在的字符串文字相同的字符串对象。

  > *The result of explicitly interning a computed string is the same* `String` *object as any pre-existing string literal with the same contents.*

## 四、String对象创建

### （1）`new String`是在堆上创建字符串对象

### （2） 通过字面量赋值创建字符串（如：String str=”hello”）时，在常量池中创建

通过字面量赋值创建字符串（如：String str=”hello”）时，会先在常量池中查找是否存在相同的字符串，若存在，则将栈中的引用直接指向该字符串；若不存在，则在常量池中生成一个字符串，再将栈中的引用指向该字符串。

### （3） 常量字符串的“+”操作，如String str = "hel"+"lo"，等同于第二种情况

### （4）常量字符串和变量拼接时（如：String str1="hel"; String str=str1+ “lo”;）会调用stringBuilder.append()在堆上创建新的对象

### （5） 对于final字段，编译期直接进行了常量替换

下面的代码讲打印true

```java
        final String a = "hel";
        final String b = "lo";
        // 在编译时，直接替换成了String c=”hel”+”lo”
        String c = a+b;
        System.out.println(c=="hello");
```

### (6) 通过`intern`方法将字符串引用插入到常量池中（如果常量池中不存在该字符串）

下面打印true：

```java
    public static void main(String[] args) {
        String str2 = new String("str")+new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str1 == str2);
    }
```

下面的打印false：(因为字符串常量池中已经存在)

```java
    public static void main(String[] args) {
        String str2 = new String("str")+new String("01");
        String str1 = "str01";
        str2.intern();
        System.out.println(str1 == str2);
    }
```

## 五、参考

参考了：[《几张图轻松理解String.intern()》](https://blog.csdn.net/tyyking/article/details/82496901)

