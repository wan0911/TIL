# WPF

[공부 자료](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/%E1%84%80%E1%85%A9%E1%86%BC%E1%84%87%E1%85%AE%20%E1%84%8C%E1%85%A1%E1%84%85%E1%85%AD%205bfbf41303094a3da82f2af7edc1f595.csv)

### 데이터 바인딩

- **타겟(컨트롤**)를 **소스(데이터)**에 연결시키는 기술
    - 소스 속성의 변화를 타겟 속성에 반영한다
- 바인딩 정의는 항상 타겟에 설정한다

<aside>
📌 **check**

- `ElementName`: 소스 **객체** 지정
- `Path`: 소스 객체의 **속성**
- 바인딩 타겟은 DependencyObject로부터 상속된다
    - 의존 프로퍼티의 지원을 받아야 함
        
        ![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled.png)
        
</aside>

- **바인딩 소스 객체 연결 방법**
    1. `**Source**`
    2. `**ElementName**`
    3. **`DataContext` :** [https://yeko90.tistory.com/entry/c-wpf-DataContext란-왜](https://yeko90.tistory.com/entry/c-wpf-DataContext%EB%9E%80-%EC%99%9C)
        - xaml 상에서 클래스 초기값을 설정하는 방법
        - 해당 UI 요소와 그 **하위 요소**에 바인딩 될 때
            
            ![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%201.png)
            
        - 데이터 묶음을 할당
- 클래스 객체 → xaml

- **바인딩 모드**
    - **oneWay** (단방향)
        
        ```csharp
        // 소스 객체
        <TextBox x:Name="txt1" Text="{Binding Mode=OneWay}"/>
        
        // 타겟 객체
        <TextBox x:Name="txt2" Text="{Binding Source={x:Reference txt1}}"/>
        ```
        
    - **twoWay** (양방향)
        
        ```csharp
        // 소스 객체
        <TextBox x:Name="txt1" Text="{Binding Path=Text, Mode=TwoWay}"/>
        
        // 타겟 객체
        
        <TextBox x:Name="txt2" Text="{Binding Source={x:Reference txt1}}"/>
        ```
        

### UI

- **Resources**
    - dynamic resource
        
        : 해당 코드를 읽을 때 스택 메모리에 할당
        
    - static resource
        
        : 프로그램 실행 초반에 힙 메모리에 할당&고정 출력
        
        : 전역 변수로 사용하고 싶을 때
        

- **영역**
    - Window
        
        : 페이지 별
        
    - App
    - Grid

- **Style 태그**
    
    : 중복되는 스타일 양식을 공유할 때
    

### MVVM 패턴

---

- View와 ViewModel간 의존성을 낮추기 위해서 사용 (독립성)
    - ex) xaml의 `click` 이벤트 → viewmodel의 `Command`
    
- view와 viewmodel간 연결이 끊기기 때문에, view의 변화를 감지하는 `propertyChanged` 속성이 중요

![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%202.png)

- 참고 자료
    
    [](https://hwanine.github.io/c#/WPF-MVVM3/)
    
    [(WPF예제)데이터 바인딩을 이용한 계산기 실습(MVVM, ViewModel)_추천닷넷/C#/자마린/WPF 실무교육센터](http://www.ojc.asia/bbs/board.php?bo_table=WPF&wr_id=5)
    
    [https://kaki104.tistory.com/531](https://kaki104.tistory.com/531)
    
    [https://velog.io/@wnsxor1993/MVVM-Clean-Architecture-정리](https://velog.io/@wnsxor1993/MVVM-Clean-Architecture-%EC%A0%95%EB%A6%AC)
    

![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%203.png)

![* Click event는 사용자 입력이다.
** view에서 사용자 입력(이벤트, 입력 값)을 viewmodel에서 처리해 줌](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%204.png)

* Click event는 사용자 입력이다.
** view에서 사용자 입력(이벤트, 입력 값)을 viewmodel에서 처리해 줌

<aside>
📎 **개요**

- **MVVM 구성**
    - M (모델) : 데이터 조작 (저장, 호출) 관련 클래스
        - ViewModel 및 View를 참조하지 않는다.
    - V (뷰) : 사용자에게 표시되는 화면 및 액티비티 클래스
        - View는 화면 로직만 가진다. 서비스 로직을 가지지 않는다.
    - VM (뷰 모델) : 뷰 를 나타내주기 위한 [모델 + 뷰] 의 로직 담당
        - View를 참조하지 않는다. Model을 참조한다.

- **MVVM 동작**
    - 사용자가 UI 화면 확인 (뷰 : XML)
    - 사용자가 UI 동작 수행 (뷰 : Activity)
    - 뷰는 뷰 모델로 이벤트 전파 (뷰 <-> 뷰 모델)
    - 뷰 모델과 모델의 데이터 상호 작용 수행 (뷰 모델 <-> 모델)
    - 뷰 모델은 뷰 화면 업데이트 수행 실시 (뷰 모델)
    
- **MVVM 장점 및 단점**
    - 뷰에 대한 의존성이 없으므로 유닛 테스트에 용이하다
    - 중복되는 코드를 모듈화 할 수 있음
    
    - 뷰 모델의 설계가 어렵다
    - 뷰 모델이 또 다른 형태의 액티비티 클래스 구현으로 변질될 수 있음
</aside>

<aside>
📌 **프로젝트에 적용하기**

---

[Microsoft.Toolkit.Mvvm을 이용한 간단한 프레임워크 part1](https://kaki104.tistory.com/806)

1. CommunityToolKitMvvm 패키지 설치

1. 폴더구조
    - Models
    - ViewModels
        - Commands
            
            : 이벤트 처리
            
    - Views

1. MainWindow.xaml을 View 안에 옮기고 App.xaml에서 `StartupUri=" /Views/MainWindow.xaml` 수정

1. Model : ObservableObject
    - CommunityToolKit에서 InotifyedPropertyChanged랑 InotifyedPropertyChaning 인터페이스 상속

</aside>

[Model-View-ViewModel - .NET](https://learn.microsoft.com/ko-kr/dotnet/architecture/maui/mvvm)

- **INotifyPropertyChanged 인터페이스**
    
    : **소스** 객체가 UI 컨트롤이 아니라, 일반 **클래스**인 경우
    
    - 프로퍼티를 변경할 때, 타겟 객체에 알려주는 메커니즘이 필요
        
        : **다수의 프로퍼티**를 다룰 때 좋다 (클래스 → 여러 프로퍼티)
        
        [https://esound.tistory.com/10](https://esound.tistory.com/10)
        
    - 데이터 변경 시 UI에 알림 → 자동으로 업데이트
    
- **UpdateSourceTrigger**
    - 대부분의 컨트롤의 기본 속성은 `**PropertyChanged**`이다.
        
        but, Text 속성은 `**LostFocus**`(포커스를 잃을 때)
        
        - **`OnPropertyChanged`**
            
            : 특정 속성이 변경될 때마다 발생하는 이벤트
            
            : UI에 바인딩된 변수가 수정되었을 때, UI 업데이트 알림을 보내주는 함수
            
            - UI 요소가 이 이벤트를 구독하여 데이터 속성 변경을 감지함
    

- Propertychanged

### 이벤트 처리

---

<aside>
📌 **작성 방식**

1. 코드 비하인드
    - 이벤트 핸들러
        - ex) `ClickBtn`
2. **command**
    
    : 이벤트 함수를 바인딩 해주는 역할
    
</aside>

<aside>
🔥 **MVVM 패턴 적용 시 유의사항**

1. `Command`로 구현
    
    : delegate 기능을 잘 써야 함…
    
2. `interactivity` 패키지 설치 후, `<i>`, `<ei>` 트리거 사용
    
    : 컨트롤마다 바인딩해서 좀 더 사용하기 편하다
    
    - 뷰에서 사용되는 컨트롤의 이벤트에 따른 조작(커맨드연결)을 편리하기 위해 사용하는 개념
</aside>

### **Command**

- mvvm 패턴에서 사용
    - View → 사용자 인터렉션 → Command → Command parameter로 값 넘김
        - View → interaction.Triggers -> EventTrigger -> InvokeCommandAction
            - InvokeCommandAction : command parameter로 넘길 값 정규화
    
- 이벤트 바인딩 방식
    - Button은 자체 프로퍼티로 `command` 속성이 있다
    - Button 이외 컨트롤은 다른 방식을 지정
        1. `EventTrigger` (코드 비하인드)
        2. `InvokeCommandAction`
            
            ```csharp
            IRelayCommand -> obj
            ```
            

---

<aside>
📌 **check point**

- mvvm 패턴 사용 시 주의사항
    - CommandParameter로 뷰의 컨트롤(UI 요소)을 직접 넘겨서 뷰모델에서 사용하는 것은 추천하지 않습니다.
        
        
    - CommandParameter로 전달하는 데이터는 모델, EventArgs 정도가 적당하다
        - CommandParameter 값에 대해 어떤 데이터 유형 지정 필요
        - 어떤 유형인지 잘 모른다면, object로 지정 후 형변환
</aside>

- `**ICommand`**
    - 뷰에서 사용자의 인터렉션을 뷰모델에 전달하기 위한 인터페이스
    - `Execute`
        
         : 커멘드 실행 시 작업 자체를 캡슐화
        
    - `CanExecute`
        
        : 커멘드 실행 명령을 호출할 수 있는지 논리
        
    - `CanExecuteChanged` : 명령 실행 여부에 영향을 주는 변경이 발생할 때 발생

1. `**IRelayCommand**`
    - `ICommand`를 상속받음, `NotifyCanExecuteChanged()`를 호출하기 위해 사용
    
2. **`AsyncRelayCommand`**
    - `IRelayCommand`와 `ICommand`를 상속 받은 인터페이스
    - Task 대응 Command

- [Delegate](C#%20c818f593b4dd44aab395a09c5d26f3e2.md)
    - Action / Func / Predicate = 클릭 시 수행할 기능

### Converter

- source -> convert -> target
- 소스와 타겟 사이에서 **데이터를 가공해서 전달**하는 역할

---

- **`Iconverter`**
    
    **:** 사용자 지정 논리 만들기
    
    1. **`IValueConverter`**
        
        ![Converter: 소스 → 타겟(ui)     /    ConvertBack: 타겟 → 소스](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%205.png)
        
        Converter: 소스 → 타겟(ui)     /    ConvertBack: 타겟 → 소스
        
        - **하나의 데이터**에 대해서만 처리
        
    2. **`IMultiValueConverter`**
        
        ![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%206.png)
        
        - **여러 데이터**를 이용해서 하나의 데이터를 반환
        - `<MultiBinding/>` 사용

- 데이터에 따른 **converter 종류**
    1. BooleanConverter
        
        ex) true/false 값 → Yes/No 문자열, Visibility
        
    2. StringConverter
        
        ex) 숫자 → 문자열 / 문자열의 대소문자를 변경
        
    3. DateTimeConverter
        
        ex) 날짜와 시간 → 다른 형식
        
    
    1. EnumConverter
        
        ex) 열거형 값 → 문자열 / 문자열 → 열거형 값
        
    2. ValueConverter
        
        : 가장 일반적으로 사용되는 Converter
        
        ex) 숫자 포맷팅, 값의 범위를 제한
        
    

[WPF Converter (컨버터, 값 변환기)](https://jasmintime.com/475)

Converter 개념 완전 정리

- 

📌 viewmodel 간 데이터 전달

[https://yh0515.tistory.com/entry/MVVMLightViewModel-간-values-전달](https://yh0515.tistory.com/entry/MVVMLightViewModel-%EA%B0%84-values-%EC%A0%84%EB%8B%AC)

### Trigger

: 동적 UI를 구성하는 기능

: 데이터 속성 변경에 따라 **style 변화**를 보조하는 역할

---

- Property trigger
    - **하나의 엘리먼트**에 트리거 지정
        - property : 마우스 호버, 다운 등..
            
            ![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%207.png)
            
        
- Control template
    - 덮어쓰기
        - 공통 소스..
    - property trigger로 속성 변경 불가
        - ControlTemplate.Trigger로 변경해줘야 함
            
            ![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%208.png)
            
        - Trigger 여러 개 지정 가능
            - 순서 중요함
                
                : 가장 아래에 있는게 우선을 적용됨
                
                ![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%209.png)
                
                ![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%2010.png)
                
- Data trigger
    - 속성 변화를 감지하여 레이아웃을 변경할 때 주로 사용
    - **서로 다른 엘리먼트 간** 트리거 지정
        - ex) 텍스트 박스 입력 → 다른 엘리먼트의 색상 변경
            
            ![Untitled](WPF%2016abaeb445d2406eb6d5b70ce6a12f93/Untitled%2011.png)
            

- dependency property
    - 사용자 정의가 가능한 속성 만들기

### db 싱글톤 패턴 적용

```jsx
using System;
using System.Data;
using System.Data.SqlClient;
using System.Windows;

namespace UserRoleManagementSystem.Common
{
    public sealed class DatabaseHelper : IDisposable
    {
        private static readonly Lazy< DatabaseHelper> instance = new Lazy< DatabaseHelper>(() => new DatabaseHelper());

        private readonly string connectionString;
        private SqlConnection connection;
        public string ConnectionString => connectionString;
        public static DatabaseHelper Instance => instance.Value;

        private DatabaseHelper()
        {
            // SQL Server 연결 문자열 설정
            SqlConnectionStringBuilder builder = new SqlConnectionStringBuilder();
            builder.DataSource = "10.1.48.184";
            builder.InitialCatalog = "INTEN_10_2_1";
            builder.UserID = "94101980";
            builder.Password = "94101980";

            connectionString = builder.ToString();
            connection = new SqlConnection(connectionString);
        }

        public SqlConnection OpenConnection()
        {
            if (connection == null)
            {
                connection = new SqlConnection(connectionString);
            }

            if (connection.State != ConnectionState.Open)
            {
                try
                {
                    connection.Open();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("데이터베이스 연결 실패: " + ex.Message);
                }
            }

            return connection;
        }

        public void CloseConnection()
        {
            if (connection.State == ConnectionState.Open)
            {
                connection.Close();
            }
        }

        public void Dispose()
        {
            if (connection != null)
            {
                connection.Dispose();
                connection = null;
            }
        }
    }
}
```