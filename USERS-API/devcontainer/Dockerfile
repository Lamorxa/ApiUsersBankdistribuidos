FROM gcc:latest


COPY . /usr/src/myapp

WORKDIR /usr/src/myapp

RUN g++ -o myapp main.cpp

RUN if [ ! -f ./myapp ]; then echo "Compilation failed"; exit 1; fi

CMD ["./myapp"]

LABEL Name=apiusersbankdistribuidos Version=0.0.1
