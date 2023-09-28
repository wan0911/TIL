
### C# 프로그램 구조

---

- **프로그램**
- **네임스페이스**
    
    : 성격이나 하는 일이 비슷한 클래스, 구조체, 인터페이스, 대리자 등을 하나의 이름 아래 묶는 역할
    
    : 용도별/분야별로 정리
    
    - 📌 대부분 파일 하나 당 네임스페이스 하나
    
    ```csharp
    namespace 네임스페이스_이름
    {
    	// 클래스
    	// 구조체
    	// 인터페이스 등..
    }
    ```
    
    - namespace = 빌딩
    - .cs 파일 (소스코드)  = 방
    
- **형식**: 클래스, 구조체, 인터페이스

- **멤버**
    - **필드**(= 변수)
        
        : 클래스/클래스 인스턴스와 연결된 변수
        
        - static → 하나의 스토리지 위치만 식별
    - **상수**
    - **메서드**
    - **property(속성)**
        
        : 클래스의 명명된 속성에 대한 읽기 및 쓰기와 관련된 작업
        
        ⇒ 속성 값을 **반환**하거나, 새로운 값 **할당** (보안 문제)
        
        ```csharp
        class MyClass
            {
                private int Field;
                public int GetField() { return Field; }
                public void SetField(int Field) { this.Field = Field; }
            }
        
        // 간단하게 지정 가능
        class 클래스명
            {
                데이터타입 필드명;
                접근한정자 데이터타입 프로퍼티명
                {
                    get
                    {
                        return 필드명;
                    }
                    set
                    {
                        필드명 = value;
                    }
                }
            }
        ```
        
    - **이벤트**
        
        : 클래스에 의해 생성될 수 있는 알림
        
    - 인덱서, 연산자, 생성자, 종료자, 형식, …
    
- **어셈블리**: 컴파일된 프로그램





## 데이터 형식 (기본, 복합)
-----
- **값 형식**
    
    : 변수가 값을 담는 데이터 형식
    
    : 스택 메모리 영역
    
    ![`}`를 만나면 메모리에서 값이 삭제된다](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%202.png)
    
    `}`를 만나면 메모리에서 값이 삭제된다
    
- **참조 형식**
    
    : 변수가 값이 있는 곳의 위치를 담는 데이터 형식
    
    : 힙 메모리 영역
    
    - 힙에선 저장된 데이터가 자동으로 제거되지 않는다
    - 가비지 컬렉터
    - 힙엔 데이터를 저장해두고, 스택엔 데이터의 위치만 올려둔다
        
        ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%203.png)
        

- **숫자형**
    
    ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%204.png)
    

- **Nullable 형식**
    - 기본적으로 C#에서 변수는 선언하면 값을 비워둘 수 없다
        
        but, 변수는 선언하고 데이터를 넣고 싶지 않다면 NULL을 이용
        
    - `**데이터_형식? 변수_이름;**`
    - **값 형식**에 한해서만 가능
    - `**HasValue**` : 해당 변수가 값을 갖고 있는지 확인 (bool)
    - `**Value**` : 변수에 담겨있는 값 확인
    
    - **null 병합 연산자 `??`**
        
        ```csharp
        int? a = null;
        Console.WriteLine($"{a ?? 0}");  // 0 출력
        
        int? a = 99;
        Console.WriteLine($"{a ?? 0}");  // 99 출력
        ```
        

- **var 형식**
    - 약한 형식 검사를 지원함
    - 컴파일러가 자동으로 변수의 형식을 지정해줌
    - **지역 변수**로만 사용 가능
    - 반드시 **초기화**해야 함
    - **📌 `var` vs `object`**
        - var 형식은 컴파일되는 시점에 자동으로 타입이 지정됨
            
            `var a = 10`;    →     `int a = 10;`
            
        - obj 형식은 참조 형식
            
            `object a = 20;`  20 → 힙, a → 참조
            




### 메소드
---

- **매개변수**
    
    ![인수가 직접 들어가는 것이 아니라, 데이터(값)이 복사되는 것이다
    별도의 메모리 할당](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%205.png)
    
    인수가 직접 들어가는 것이 아니라, 데이터(값)이 복사되는 것이다
    별도의 메모리 할당
    
- **참조 매개변수**
    
    : 메서드에서 값을 바꿀 때 인수도 같이 바꿔주고 싶다
    
    📌 값을 받는게 아니라 **값의 위치(=메모리 주소)**를 받는다!!
    
    ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%206.png)
    
    ```csharp
    static void Swap(**ref** int a, **ref** int b)
    {
    		int temp = b;
    		b = a;
    		a = b;
    }
    ```
    

- **메서드의 결과**를 **참조**로 반환
    - 메서드 선언, return문 앞에 `**ref**` 한정자 사용
        
        ```csharp
        class SomeClass 
        {
        		int SomeValue = 10;
        
        		public **ref** int SomeMethod()
        		{
        				return **ref** SomeValue;
        		}
        }
        
        // 참조 반환 값 사용
        ref int result = ref obj.SomeMethod; // 지역 변수
        ```
        
    - 참조 인수는 지역변수에 한정되기 때문에, 값이 아니라 참조를 받으려면 형식자 앞에 **ref를 무조건** 붙여줘야 한다!
        
        ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%207.png)
        
        - 예시 코드
            
            ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%208.png)
            

- **출력 전용 매개변수 `out`**
    - 📌 `**ref**` vs `**out**`
        - 매개변수를 넘길 때, ref는 결과 값이 저장되지 않아도 된다
            
            but, out은 결과 값이 저장되지 않으면 오류난다
            
            ```csharp
            // ref 매개변수
            void Divide(int a; int b; ref int quotient, ref remainder)
            {
            		quotient = a / b;
            		remainder = a % b;
            }
            
            Diide(a, b, ref c, ref d);
            
            // out 매개변수
            void Divide(int a; int b; out int quotient, out remainder)
            {
            		quotient = a / b;
            		remainder = a % b;
            }
            
            Diide(a, b, out c, out d);
            ```
            
            ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%209.png)
            
            ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%2010.png)
            

- **메소드 오버로딩**
    
    

### **클래스, 객체**

- 클래스(붕어빵 틀) ↔ 인스턴스(붕어빵)
    - c# 프로그램을 구성하는 기본 단위
    - 데이터 + 데이터를 처리하는 메소드
    - 클래스엔 메인 메소드가 무조건 필요하다
    
    ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%2011.png)
    
    ```csharp
    public class Point //클래스
    {
    		// 프로퍼티
        public int X { get; } 
        public int Y { get; }
        
    		// 생성자
    		// 클래스명과 일치!
        public Point(int x, int y) => (X, Y) = (x, y);
    }
    ```
    
    ```csharp
    public class PointFactory(int numberOfPoints)
    {
        public IEnumerable<Point> CreatePoints()
        {
            var generator = new Random();
            for (int i = 0; i < numberOfPoints; i++)
            {
                yield return new Point(generator.Next(), generator.Next());
            }
        }
    }
    ```
    

- 생성자와 종료자의 명시적 구현은 **선택사항**
    
    : 클래스 선언 시 컴파일러에서 자동으로 **기본 생성자**를 구현해준다
    
    - **생성자:** 객체(인스턴스)가 생성될 때 호출됨
        
        📌 시그니처에 따라 생성자가 구분된다!
        
        ```csharp
        // 생성자 선언 //
        class Cat
        {
        	// 생성자 버전 1
        	public Cat()  // 한정자 + 생성자
            {
            	Name = "";
                Color = "";
            }
        
            // 생성자 버전 2
            public Cat( string _Name, string _Color) // 객체 생성시 이름과 색을 입력받아 초기화
            {
            	Name = _Name;
                Color = _Color;
            }
        
            public string Name;
            public string Color;
        
            //...
         }
        
         // 생성자 호출 및 사용 //
        
         // 생성자 버전 1 호출
         Cat kitty = new Cat(); // Cat()
         kitty.Name = "키티";
         kitty.color = "하얀색";
        
         // 생성자 버전 2 호출
         Cat nabi = new Cat("나비", "갈색");  // Cat(string _Name, string _Color)
        ```
        
    - **종료자**: 객체가 소멸될 때 호출됨
        - `~`로 선언
        - 가비지 컬렉터

- **객체 복사**
    - **shallow copy**
        
        ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%2012.png)
        
        : 객체 복사가아닌 힙에 있는 메모리 주소 참조
        
    - **deep copy**
        
        ![Untitled](C#%20c818f593b4dd44aab395a09c5d26f3e2/Untitled%2013.png)
        
        : 힙에 있는 객체를 복사하여 별도의 힙에 새로 할당
        
    
- **접근 한정자**
    - `public` : 클래스의 내/외부 모든 곳에서 접근 가능
    - `protected` : 클래스 외부에서 접근 X, 파생 클래스에서 접근 가능
    - `private` : 클래스 내부에서만 접근 가능, 파생 클래스에서 접근 X
    - `internal` : 같은 어셈블리 내에서만 public으로 접근 가능
    - `protected internal` : 같은 어셈블리 내에서만 protected으로 접근 가능
    - `private protected` : 같은 어셈블리 내의 클래스에서 상속받은 클래스 내부에서만 접근 가능
        
        📌 접근 한정자를 지정하지 않으면 `private`로 자동 지정
        

### **기본 클래스**

- 클래스 선언 시, `:`로 기본 클래스 지정 가능
- 기본 클래스의 멤버 상속

```csharp
public class Point3D : Point
{
    public int Z { get; set; }
    
    public Point3D(int x, int y, int z) : base(x, y)
    {
        Z = z;
    }
}
```

```csharp
Point a = new(10, 20);
Point b = new Point3D(10, 20, 30);
```

### 정적 필드 & 메소드

- **static**
    
    : 메소드나 필드가 클래스의 인스턴스가 아닌 **클래스 자체**에 소속되도록 지정
    
    : 특정 메모리 공간에 위치 (= 프로그램 상 단 하나 → 중복 x )
    
    ```csharp
    // 인스턴스에 소속된 경우
    // 생성자로 생성해야 함
    class MyClass 
    {
    	public int a;
    	public int b;
    }
    
    public static void Main()
    {
    	Myclass obj1 = new MyClass();
    	obj1.a = 1;
    	obj1.b = 2;
    
    	Myclass obj2 = new MyClass();
    	obj2.a = 1;
    	obj2.b = 2;
    }
    
    // static 클래스에 소속된 경우
    // 인스턴스를 생성하지 않고 바로 사용!
    // static 클래스는 단 1개만 존재
    class MyClass 
    {
    	public static int a;
    	public static int b;
    }
    
    public static void Main()
    {
    	Myclass.a = 1;
    	Myclass.a = 1;
    }
    ```
    

- **static method**
    
    : 클래스 자체에 소속되는 메소드
    
    ```csharp
    // 정적 메소드 //
    class MyClass
    {
    	public static void StaticMethod() // static 사용
       {}
    }
    
    MyClass.StaticMethod();  // 인스턴스 만들지 않고도 바로 호출 가능
    
    // 인스턴스 메소드 //
    class MyClass
    {
    	public void StaticMethod() // static 사용X
       {}
    }
    
    MyClass obj = new MyClass(); // 인스턴스 생성
    obj.InstanceMethod(); // 인스턴스를 만들어야 호출 가능
    ```
    

### 매개 변수

---

- **값 매개 변수**
    
    : 입력 값 전달
    
- **참조 매개 변수**
    
    : 인수를 참조로 전달
    
    : 인수에 값 명시적 할당 필요 O
    
    : `ref`
    
    ```csharp
    static void Swap(ref int x, ref int y)
    {
        int temp = x;
        x = y;
        y = temp;
    }
    
    public static void SwapExample()
    {
        int i = 1, j = 2;
        Swap(ref i, ref j);
        Console.WriteLine($"{i} {j}");    // "2 1"
    }
    ```
    
- **출력 매개 변수**
    
    : 인수를 참조로 전달
    
    : 인수에 값 명시적 할당 필요 X
    
    ```csharp
    static void Divide(int x, int y, out int quotient, out int remainder)
    {
        quotient = x / y;
        remainder = x % y;
    }
    
    public static void OutUsage()
    {
        Divide(10, 3, out int quo, out int rem);
        Console.WriteLine($"{quo} {rem}");	// "3 1"
    }
    ```
    
- **매개 변수 배열**
    
    : 다양한 개수의 인수를 메서드에 전달
    
    : 1차원 배열 형식
    

### **형식 매개 변수**

: 대괄호`<>`로 묶인 형식 매개 변수 이름 목록

: 클래스의 이름을 따른다

: 제네릭 클래스 형식

```csharp
public class Pair<TFirst, TSecond>
{
    public TFirst First { get; }
    public TSecond Second { get; }
    
    public Pair(TFirst first, TSecond second) => 
        (First, Second) = (first, second);
}

// 형식 인수
var pair = new Pair<int, string>(1, "two");
int i = pair.First;     //TFirst int
string s = pair.Second; //TSecond string
```

### 형식

- **값 형식**
    - **구조체**
    - **deepcopy**
    - **stack** memory에 할당 (값 자체를 복사, push, pop)
    
    ```csharp
    using System;
    
    public struct MutablePoint
    {
        public int X;
        public int Y;
    
        public MutablePoint(int x, int y) => (X, Y) = (x, y);
    
        public override string ToString() => $"({X}, {Y})";
    }
    
    public class Program
    {
        public static void Main()
        {
            var p1 = new MutablePoint(1, 2);
            var p2 = p1;
            p2.Y = 200; // p2 = (1, 200)
    					// 여기서 p2는 p1의 구조체를 복사 + Y 속성만 지정
    					// 값 형식은 변화하지 않는다.
            Console.WriteLine($"{nameof(p1)} after {nameof(p2)} is modified: {p1}");
            Console.WriteLine($"{nameof(p2)}: {p2}");
    
            MutateAndDisplay(p2);
            Console.WriteLine($"{nameof(p2)} after passing to a method: {p2}");
        }
    
        private static void MutateAndDisplay(MutablePoint p)
        {
            p.X = 100;
            Console.WriteLine($"Point mutated in a method: {p}");
        }
    }
    // Expected output:
    // p1 after p2 is modified: (1, 2)
    // p2: (1, 200)
    // Point mutated in a method: (100, 200)
    // p2 after passing to a method: (1, 200)
    ```
    
- **참조 형식**
    - **클래스**
    - **shallow copy**
    - **heap** memory에 할당 (값 자체 x, 메모리 주소 참조)
    
    : 다른 인스턴스를 수정하면 기존의 클래스도 수정
    

### **구조체**

<aside>
💡 **point**

- 클래스는 **상속**과 **다형성** 지원
    
    → 파생 클래스를 기반으로 정교한 동작을 만들 수 있다
    
- 구조체는 **데이터 값을 저장**하는 것이 주 목적이다
    
    → 파생 구조체를 만들 수 없음 = 새로운 형식을 추가할 수 없다
    
    - 모든 필드에 값을 할당해야 한다
</aside>

```csharp
public struct Point
{
    public double X { get; }
    public double Y { get; }
    
    public Point(double x, double y) => (X, Y) = (x, y);
}
```

```csharp
struct Person
{
  public string name;
}

class Program
{
  static void Main(string[] args)
  {
    Person person1 = new Person();
    person1.name = "둘리";

    Person person2 = person1;
    person2.name = "마이콜";

    Console.WriteLine("person1.name: " + person1.name);
    Console.WriteLine("person2.name: " + person2.name);
  }
}

// person1.name: 둘리
// person2.name: 마이콜
```

### **인터페이스**

: 클래스 및 구조체에서 구현할 수 있는 계약을 정의

- 메서드, 속성, 이벤트, 인덱서
- **다중** **상속** 가능

```csharp
interface IControl
{
    void Paint();
}

interface ITextBox : IControl
{
    void SetText(string text);
}

interface IListBox : IControl
{
    void SetItems(string[] items);
}

interface IComboBox : ITextBox, IListBox { }
```

### 열거형 (enum)

: 상수 값 집합

```csharp
public enum SomeRootVegetable
{
    HorseRadish,
    Radish,
    Turnip
}
```

```csharp
[Flags]
public enum Seasons
{
    None = 0,
    Summer = 1,
    Autumn = 2,
    Winter = 4,
    Spring = 8,
    All = Summer | Autumn | Winter | Spring
}

// 사용 예시
var turnip = SomeRootVegetable.Turnip;

var spring = Seasons.Spring;
var startingOnEquinox = Seasons.Spring | Seasons.Autumn;
var theYear = Seasons.All;
```

### Nullable 유형

```csharp
int? optionalInt = default; 
optionalInt = 5;
string? optionalText = default;
optionalText = "Hello World.";
```

### 튜플

```csharp
(double Sum, int Count) t2 = (4.5, 3);
Console.WriteLine($"Sum of {t2.Count} elements is {t2.Sum}.");
//Output:
//Sum of 3 elements is 4.5.
```

### Delegate

- 함수를 변수에 담아 호출하고 싶을 때 사용
- 델리게이트에 함수를 담는다!
    - return 값을 다른 함수의 매개변수로 사용 가능

> Delegate를 선언하지 않고 기능 구현 가능한 방법
> 
- **Action**
    - return 값이 없을 때만 사용 가능
        - 단순히 콘솔로 출력만 가능
    - 매개변수 받을 수 있다
- **Func**
    - 여러 개의 매개변수
        - 타입, 반환 값
- **Predicate**
    - return = bool
        - 매개변수만 명시해주면 된다
