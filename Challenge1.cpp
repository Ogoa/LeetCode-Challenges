#include<bits/std++.h>
using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        int value = 0; //This will hold the final integer value after being converted from Roman numerals.
        map<key, value> map;<char, int> romanNumerals {{'M', 1000}, {'D', 500}, {'C', 100}, {'L', 50}, {'X', 10}, {'V', 5}, {'I', 1}};
        if(s.length()>=1 && s.length()<=15) { //Condition to ensure the length of string is within the range of 1 and 15 characters
            for(int i=0; i<=s.length(); i++) {
                if(auto num = romanNumerals.find(s[i]); num!=romanNumerals.end()) { //This is to evaluate if the each character in the string is contained in the keys of the dictionary
                    switch(s[i]) {
                        case 'I': {
                            if(s[i+1]=='V' || s[i+1]=='X') {
                                value-=1;
                            } else {
                                value+=1;
                            }
                        }
                        break;
                        case 'V':
                        value+=5;
                        break;
                        case 'X': {
                            if(s[i+1]=='L' || s[i+1]=='C'){
                                value-=10;
                            } else {
                                value+=10;
                            }
                        }
                        break;
                        case 'L':
                        value+=50;
                        break;
                        case 'C':{
                            if(s[i+1]=='D' || s[i+1]=='M') {
                                value-=100;
                            } else {
                                value+=100;
                            }
                        }
                        break;
                        case 'D':
                        value+=500;
                        break;
                        case 'M':
                        value+=1000;
                        break;
                        default:
                        value+=0;
                    }
                }
            }
        }
        else {
            return -1;
        }
        return value;
    }
};

int main() {
  Solution solution; //Creating an instance of the class 'Solution'
  string num; //Variable to store the user's input
  cout << "Enter a number in Roman Numerals:\n";
  cin >> num;
  cout << "\nThe Roman numeral " << num << " is = " << solution.romanToInt(num);
}
