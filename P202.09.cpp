// P202.09.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include<string>
#include<iostream>
 using namespace std;
 class Teacher 
 {
 public: 
 Teacher(string nam,int a,char s,string tit,string ad,string t); 
 void display(); 

 protected:
	 string name; 
	 int age;
	 char sex;
	 string title; 
	 string addr;
	 string tel; 
 };

Teacher:: Teacher(string nam, int a, char s, string tit, string ad, string t) : name(nam), age(a), sex(s), title(tit), addr(ad), tel(t) {} 
void Teacher::display()
{ cout << "name:" << name << endl; cout << "age" << age << endl; cout << "sex:" << sex << endl; cout << "title:" << title << endl; cout << "address:" << addr << endl; cout << "tel:" << tel << endl; }

class Cadre

{
	public:
		Cadre(string nam,int a,char s,string p,string ad,string t); 
		void display();
protected:
	string name; 
	int age; 
	char sex; 
	string post; 
	string addr; 
	string tel;
};

Cadre::Cadre(string nam, int a, char s, string p, string ad, string t) : name(nam), age(a), sex(s), post(p), addr(ad), tel(t) {}

void Cadre::display() 
{
	cout << "name:" << name << endl; cout << "age:" << age << endl; 
	cout << "sex:" << sex << endl; cout << "post:" << post << endl; 
	cout << "address:" << addr << endl; cout << "tel:" << tel << endl; 
}

class Teacher_Cadre:public Teacher, public Cadre
{ 
public:
	Teacher_Cadre(string nam,int a,char s,string tit,string p,string ad,string t,float w);
	void show();
private: 
	float wage; 
};
Teacher_Cadre::Teacher_Cadre(string nam, int a, char s, string t, string p, string ad, string tel, float w) : Teacher(nam, a, s, t, ad, tel), Cadre(nam, a, s, p, ad, tel), wage(w) {} 

void Teacher_Cadre::show()
{ 
	Teacher::display(); cout << "post:" << Cadre::post << endl; cout << "wages:" << wage << endl;
}

int main() {
	Teacher_Cadre te_ca("XI", 20, 'G', "prof.", "Teacher", "618000 Sichuan deyang", "000100101", 2000.0); 
	te_ca.show(); 
	return 0; }

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
