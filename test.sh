rm -rf -r out
javac test/*.java src/*.java -d out
cd out && java Tester
cd ..