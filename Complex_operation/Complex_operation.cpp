// Complex_operation.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include<iostream> 
#include<stdio.h> 
using namespace std;

class Real {
protected:
	double real;

public:
	Real() {
		real = 0;
	}
	Real(double r) {
		real = r;
	}

	virtual void display() {
		cout << "Real=" << real << endl;
	}

	virtual Real operator+(Real& c) {
		Real t;
		t.real = real + c.real;
		return t;
	}

	virtual Real operator-(Real& c) {
		Real t;
		t.real = real - c.real;
		return t;
	}

	virtual Real operator/(Real& c) {
		Real t;
		t.real = real / c.real;
		return t;
	}
	virtual Real operator*(Real& c) {
		Real t;
		t.real = real * c.real;
		return t;
	}
};


class Complex :public Real {
private:
	double image;

public:
	Complex() {
		image = 0; real = 0;
	}

	Complex(double m, double n) :Real(m) {
		image = n;
	}

	virtual void display() {
		cout << "real=" << real << "  " << "image=" << image << endl;
		cout << "(" << real << "," << image << ")" << endl;
	}

	virtual Complex operator+(Complex& c) {
		Complex t;
		t.real = real + c.real;
		t.image = image + c.image;
		return t;
	}

	virtual Complex operator-(Complex& c) {
		Complex t;
		t.real = real - c.real;
		t.image = image - c.image;
		return t;
	}

	virtual Complex operator*(Complex& c) {
		Complex t;
		t.real = real * c.real;
		t.image = image * c.image;
		return t;
	}

	virtual Complex operator/(Complex& c) {
		Complex t;
		t.real = real / c.real;
		t.image = image / c.image;
		return t;
	}
};

void StartComplex() {
	char ch = 0;
	cout << "欢迎 四则运算计算器" << endl;
	cout << "请选择下面任意一个进行运算:  +  -  *  /  " << endl;
	cin >> ch;
	double r1, r2, img1, img2;
	cout << "请输入第一个复数的实部和虚部：" << endl;
	cin >> r1 >> img1;
	Complex c1(r1, img1);
	cout << "请输入第二个复数的实部和虚部：" << endl;
	cin >> r2 >> img2;
	Complex c2(r2, img2);

	Complex c;
	if (ch == '+') {
		c = c1 + c2; c.display();
	}
	else if (ch == '-') {
		c = c1 - c2; c.display();
	}
	else if (ch == '/') {
		c = c1 / c2; c.display();
	}
	else if (ch == '*') {
		c = c1 * c2; c.display();
	}
}

int main() {
	StartComplex();
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
