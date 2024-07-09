#### IP (인터넷 계층)
- 역할
  - IP 주소(IP Address)에 데이터 전달
  - 패킷(통신 단위)으로 데이터 전달
- 특징
  1. 비연결성
    : 대상 서버가 서비스 가능 상태인지 확인 X
  2. 비신뢰성
    : 패킷 소실
    : 패킷 전달 순서
  3. 프로그램 구분 

<br/>

#### TCP/UDP (전송 계층)

TCP : 전송 제어 프로토콜 (Transmission Control Protocol)
- 특징
  1. 연결지향 - TCP 3 way handshake (SYN - ACK)  
  2. 신뢰성
     - 데이터 전달 보증
     - 순서 보장
     - 신뢰할 수 있는 프로토콜

UDP : 사용자 데이터그램 프로토콜 (User Datagram Protocol)
- 특징
  1. 기능이 거의 없다
  2. IP + PORT + 체크섬 ..

PORT: 같은 IP 내에서 프로세스 구분
DNS(Domain Name System)
- 도메인 네임 -> IP 주소로 변환
  - IP는 기억하기 어렵다
  - IP는 변경될 수 있음
