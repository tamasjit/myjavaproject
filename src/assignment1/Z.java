package assignment1;

public class Z {
	public static void main (String args[]) {
		new M().methodPublic();
		new M().methodProtected();
		new M().methodDefault();
		new N().methodPublic();
		new N().methodProtected();
		new N().methodDefault();
		new P().callFromClassMN();
		new X().methodPublic();
	}
	

}
