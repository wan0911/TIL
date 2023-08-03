class Person {
    constructor(name="alaenwaler", IQ=100, str=100) {
        this.name = name;
        thks.IQ = IQ;
        this.str = str;
    }   // 속성

    levelup() {
        this.IQ++;
        this.str++;
    } // 메서드
}

const a = new Person();
a.levelup();

const b = new Person();
b.levelup();



// static
class Person {
    constructor(name="alaenwaler", IQ=100, str=100) {
        this.name = name;
        thks.IQ = IQ;
        this.str = str;
    }   // 속성

    levelup() {
        this.IQ++;
        this.str++;
    } // 메서드

    static talk(a, b) {
        console.log(a.name + "&" + b.name + "이 대화를 시작했다!");
    }
    
    static GUDOC = "큰 돌의 터전";
}

const a = new Person();
b.levelup();
// static method 사용
Person.talk(a, b);
console.log(Person.GUDOC);
