package nested;

public class Nested {
	class inner{
		int i = 1;
		int inc() {return  i + 6;}
	}
	//class in class and in methods ![closure]
	public void meth() {
		int i=0;
		class X{
			int inc() {
				return i+1;
			}
		}
	}
	//anonymous inner classes!
}
