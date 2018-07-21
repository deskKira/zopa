# zopa test
zopa test work

Before start you should have:
* Installed git
* Installed java (version 8.+)
* Installed maven (version 3.+)
* Test file in correct format with lenders

File format 
--------------------------
|Lender | Rate |Available|
--------------------------

lender - some string name;
rate - some double value of rate;
available - some available sum on the lender account; 

## For start to do the follow things:
* To clone the repository: git clone https://github.com/deskKira/zopa.git or click download zip
* Run the next command: `mvn clean package`. In result you should get the file **credit-1.0-jar-with-dependencies.jar** in target directory of the project
* Run the command: 
```
java -jar credit-1.0-jar-with-dependencies.jar arg1 arg2
```
Where `arg1` - path to file with lenders in csv format, `agr2` - requested amount

## Example:
```
java -jar credit-1.0-jar-with-dependencies.jar market.csv 1000
```

## Result:
```
Requested amount: £1000
Rate:7.0
Monthly repayment: £30.88
Total repayment: £1111.64
```
