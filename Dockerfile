# OpenJDK 이미지 사용
FROM openjdk:17

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 jar 파일을 컨테이너 내 /app 디렉토리로 복사
COPY ./build/libs/backend-0.0.1-SNAPSHOT.jar /app/server.jar

# 애플리케이션 실행
CMD ["java", "-jar", "server.jar"]
