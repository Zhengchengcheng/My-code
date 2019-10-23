// Multiple_derived_classes.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include<iostream>
#include<math.h>
using namespace std;
#define PI 3.14

class Shape {
public:
	virtual float Circumference() = 0;//求自身周长
	virtual float Area() = 0;//求自身面积
};

class Circle :public Shape {
public:
	Circle(float R) {
		CR = R;
	}

	float Circumference() {
		return 2 * PI * CR;
	}

	float Area() {
		return float(PI * CR * CR);
	}

private:
	float CR;
};

class Ellipse :public Shape {
public:
	Ellipse(float a1, float b1) {
		a = a1;
		b = b1;
	}

	float Circumference() {
		float temp1 = (float)(1.5) * (a + b);
		float temp2 = (float)sqrt(a * b);
		return (float)PI * (temp1 - temp2);
	}

	float Area() {
		return float(PI * a * b);
	}

private:
	float a;
	float b;
};

class Triangle :public Shape {
public:
	Triangle(float a1, float b1, float c1) {
		a = a1;
		b = b1;
		c = c1;
	}

	float Circumference() {
		return a + b + c;
	}

	float Area() {
		float p = (a + b + c) / 2;
		return (float)sqrt(p * (p - a) * (p - b) * (p - c));
	}

private:
	float a;
	float b;
	float c;
};

class Rectangle :public Shape {
public:
	Rectangle(float a1, float b1) {
		a = a1;
		b = b1;
	}

	float Circumference() {
		return 2 * (a + b);
	}

	float Area() {

		return float(a * b);
	}
private:
	float a;
	float b;
};

int main() {
	Circle circle(1.0);
	Ellipse ellipse(4.0, 6.0);
	Triangle triangle(3.0, 4.0, 5.0);
	Rectangle rectangle(3.0, 4.0);

	Shape* p[4] = {
		&circle,&ellipse,&triangle,&rectangle
	};

	float Cirs = 0, Ares = 0;
	for (int i = 0; i < 4; i++) {
		Cirs += p[i]->Circumference();/*周长之和*/
		Ares += p[i]->Area();/*面积之和*/
	}
	//输出总的周长和面积
	cout << "周长总和" << Cirs << endl;
	cout << "面积总和" << Ares << endl;
	//输出单个的周长和面积
	cout << "Circumference of circle =" << p[0]->Circumference() << endl;
	cout << "Area of circle =" << p[0]->Area() << endl;
	cout << "Circumference of ellipse =" << p[1]->Circumference() << endl;
	cout << "Area of ellipse =" << p[1]->Area() << endl;
	cout << "Circumference of triangle =" << p[2]->Circumference() << endl;
	cout << "Area of triangle =" << p[2]->Area() << endl;
	cout << "Circumference of rectangle =" << p[3]->Circumference() << endl;
	cout << "Area of rectangle =" << p[3]->Area() << endl;
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
