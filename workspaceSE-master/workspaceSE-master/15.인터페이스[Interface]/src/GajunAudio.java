
public class GajunAudio implements GajunOnOff, GajunVolume{
	//GajunOnOff, GajunVolume 나누면 디테일있게 설정가능. 
	
	@Override
	public void up() {
		System.out.println("Audio.up()");
	}

	@Override
	public void down() {
		System.out.println("Audio.down()");
	}

	@Override
	public void on() {
		System.out.println("Audio.on()");
	}

	@Override
	public void off() {
		System.out.println("Audio.off()");
	}
}
