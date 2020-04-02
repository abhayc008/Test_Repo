package abstraction;

abstract class Person
{
	public abstract void id();
	public abstract void name();
	public abstract void age();
	public abstract void gender();
	public void breathing() 
	{
		System.out.println("breathing");
	}
}
class Trainer extends Person
{

	@Override
	public void id() {
		System.out.println("445");
		
	}

	@Override
	public void name() {
		System.out.println("Geeta");
		
	}

	@Override
	public void age() {
		System.out.println("28");
		
	}

	@Override
	public void gender() {
		System.out.println("female");
		
	}
	public void teachingskill() 
	{
		System.out.println("computer");
	}

}

public class Coder 
{

	public static void main(String[] args) 
	{
		Person person =new Trainer();//upcasting
        Trainer trainer=new Trainer();//static binding
        person.id();
        person.name();
        person.age();
        person.gender();
        person.breathing();
        
        trainer.teachingskill();
	}

}
