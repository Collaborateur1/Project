package other;

public class test {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
       
   
long time,time2;
time=System.currentTimeMillis();
int c=1000000;

String[][] st= new String[5][2];

System.out.println(st.length );
//String st="";
//
//for(int i=0;i<c;i++)
//{
//    st=st+"azertyuiopqsdfghjklmwxcvbn1234567899874563210+-*";
//    
//}

//StringBuilder st=new StringBuilder();
//
//for(int i=0;i<c;i++)
//{
//    st.append("azertyuiopqsdfghjklmwxcvbn1234567899874563210+-*");
//    
//}

//
//StringBuffer st=new StringBuffer();
//
//for(int i=0;i<c;i++)
//{
//    st.append("azertyuiopqsdfghjklmwxcvbn1234567899874563210+-*");
//    
//}

time2=System.currentTimeMillis();
System.out.println( (time2-time)+" Milli" );
System.out.println( ((time2-time)/1000)+" Seconde" );
}

}