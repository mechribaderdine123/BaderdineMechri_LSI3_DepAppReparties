package calcul;
	import java.io.Serializable;
public class Calculatice implements Serializable{ 
	
		
		private int nb1;
		private int nb2;
		private String  op ;
		
		public Calculatice(int nb1, String op,int nb2 ) {
			this.nb1=nb1;
			this.op= op;
			this.nb2=nb2;
		}

		public int getNb1() {
			return nb1;
		}

		public void setNb1(int nb1) {
			this.nb1 = nb1;
		}

		public int getNb2() {
			return nb2;
		}

		public void setNb2(int nb2) {
			this.nb2 = nb2;
		}

		public String getOp() {
			return op;
		}

		public void setOp(String op) {
			this.op = op;
		}

		@Override
		public String toString() {
			return "Calculatrice [nb1=" + nb1 + ", nb2=" + nb2 + ", op=" + op + "]";
		}
		
		

	}

