// Wages.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include<string>
using namespace std;

class Person{
public:
	void display()
	{
		double pay;
		pay = basePay + hourPay * workHour + allMoney * raisePay;
		cout << "本月的工资为：" << pay << endl;
		cout << endl;

	}
protected:
	long int basePay;
	int hourPay;
	int workHour;
	double raisePay;
	long int allMoney;
};

class Manager :public Person {
public:
	Manager()
	{
		basePay = 15000;
		hourPay = 0;
		workHour = 0;
		raisePay = 0;
		cout << "请输入公司经理销售总额:" << endl;
		cin >> allMoney;

	}
};

class Parttime :public Person {
public:
	Parttime()
	{
		basePay = 0;
		hourPay = 180;
		cout << "请输入兼职人员工作了多长时间:" << endl;
		cin >> workHour;
		cout << "请输入兼职人员销售总额:" << endl;
		cin >> allMoney;
		raisePay = 0;
	}

};

class SaleManager :public Person
{
public:
	SaleManager()
	{
		basePay = 5000;
		hourPay = 0;
		workHour = 0;
		raisePay = 0.01;
		cout << "请输入销售经理经理销售总额:" << endl;
		cin >> allMoney;
	}
};

class SalePerson :public Person
{
public:
	SalePerson()
	{
		basePay = 0;
		hourPay = 0;
		workHour = 0;
		raisePay = 0.06;
		cout << "请输入销售员销售总额:" << endl;
		cin >> allMoney;
	}
};
int main()
{
	Manager manager;
	manager.display();

	Parttime part;
	part.display();

	SaleManager salemanager;
	salemanager.display();

	SalePerson saleperson;
	saleperson.display();
	return 0;
}




// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
