
public class GajunSmartPhone implements GajunOnOff, GajunVolume {

	@Override
	public void up() {
		System.out.println("GajunSmartPhone.up()");
	}

	@Override
	public void down() {
		System.out.println("GajunSmartPhone.down()");
	}

	@Override
	public void on() {
		System.out.println("GajunSmartPhone.on()");
	}

	@Override
	public void off() {
		System.out.println("GajunSmartPhone.off()");
	}

}
