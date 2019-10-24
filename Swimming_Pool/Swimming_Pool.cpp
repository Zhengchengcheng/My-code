// Swimming_Pool.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;

const float PI = 3.14159;
const float FencePrice = 35;
const float ConcretePrice = 20;

class Circle {
private:
	float Radius;
public:
	Circle(float r);  //构造函数
	float Circumference(); //圆周长
	float Area();  //圆面积
};

Circle::Circle(float r) {
	Radius = r;
}

// 计算圆的周长
float Circle::Circumference() {
	return 2 * PI * Radius;
}

// 计算圆的面积 
float Circle::Area() {
	return PI * Radius * Radius;
}

int main() {
	float Radius, FenceCost, ConcreteCost;
	cout << "Enter the radius of the pool: ";
	cin >> Radius;
// 声明 Circle 对象
	Circle Pool(Radius);
	Circle PoolRim(Radius + 3);
	FenceCost = PoolRim.Circumference() * FencePrice;
	cout << "Fencing Cost is " << FenceCost << endl;
//  计算过道造价并输出
	ConcreteCost = (PoolRim.Area() - Pool.Area()) * ConcretePrice;
	cout << "Concrete Cost is " << ConcreteCost << endl;
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
