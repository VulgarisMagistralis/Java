package notes;

public class Notes {
	/*
	 * UML = unified modeling language
	 * class diagrams <-
	 * activity diagrams
	 * use case diagrams
	 * abstract{classes}
	 * concrete {objects}
	 *	 + printName(): void
	 *	 + getSalary(): double
	 *message passing
	 *Department : DAUIN ---[printName()]---> Person : John =>?
	 *Multiplicity *
	 *car{0..1} ---[mount()] --> Wheel{0..4}
	 *a wheel can be mounted to one car or none // maximum 4 wheels can be mounted to a  car
	 * 0, 1 , *=> most common numbers * = many
	 *some examples on slides
	 *Aggregation 
	 *B is a part of  A
	 *car - engine
	 *car - tyre
	 *car - door
	 *Inheritance !!!
	 *a class that is a subtype of a class
	 *
	 *Specialization / Generalization
	 *parent , child
	 *superclass = ancestor = base class =>classes are above
	 *subclasses= derived = descendant class => far below
	 *more effective => don't make shallow and deep inheritance tree
	 * 3-4 is fine
	 *overriding parent class' methods
	 *burrow 
	 *polymorphism =. extra work for compiler
	 *localization of code => fix class bugs -> fixed in all derivations
	 *
	 *Strongly typed language
	 *casting classes ==casts only the reference not the object
	 *upcast -> special to general type // totally fine just loses details
	 *downcast -> general to special type // must be explicit 
	 *manager mm = (manager)employee;not safe
	 *if you are using this you are not doing something right
	 *to safely downcast use instance of
	 *if(staff[1] instanceof Manager){
	 *manager = (Manager) staff[1];
	 *}
	 *
	 *OVERRIDE METHODS!!!!!
	 *
	 *Polymorphism and dynamic bounding
	 *Car mycar = new Car();
	 *myCar = new Car() wut;
	 *
	 *DON'T USE INSTANCEOF < USE THIS;
	 *Static check -> complies
	 *dynamic binding -> when a subclass is using an overridden method
	 *it calls the one in the derived class not in super();
	 *JVM finds it 
	 *so different subclsses can be treated uniformly
	 *
	 *Duck typing, why bother ?
	 *
	 *for subclasses by conditioning(or some checks) you can use super class methods 
	 *void turnon(){
	 *	if(charged){
	 *  	super.turnon();
	 *	}
	 *}
	 *
	 *
	 *super() finds the first wanted method in the classes above
	 *
	 *this and static methods not used together obviously
	 *
	 *OVERLOAD - same name
	 *OVERRIDE - same signature
	 *
	 *
	 *
	 *
	 *
	 * */
}
