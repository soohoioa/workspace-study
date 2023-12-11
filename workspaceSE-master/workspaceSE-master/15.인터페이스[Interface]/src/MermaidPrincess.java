public class MermaidPrincess extends Object implements Mermaid, Princess {

	@Override
	public void Speak() {
		System.out.println("Princess.speak() 의 구현[재정의]");		
	}

	@Override
	public void think() {
		System.out.println("Princess.think() 의 구현[재정의]");
	}

	@Override
	public void liveSea() {
		System.out.println("Mermain.liveSea() 의 구현[재정의]");
	}

	@Override
	public void fastSwim() {
		System.out.println("Mermain.fastSwim() 의 구현[재정의]");	
	}

}
