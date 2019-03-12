package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Olivier Liechti
 */
public class UpperCaseFilterWriter extends FilterWriter {
  
  public UpperCaseFilterWriter(Writer wrappedWriter) {
    super(wrappedWriter);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
	 
	  String temp = str.substring(off, len+off);
	  
	  temp = temp.toUpperCase();
	  this.out.write(temp);
	  
	  
	  
   // throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
	  
	  for(int i = off; i < len+off; i++) { 
		  this.write(cbuf[i]);
	  }
	  

	  
	  
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

  @Override
  public void write(int c) throws IOException {
	  
	  int temp = Character.toUpperCase((char)c);
	  this.out.write(temp);  
	  
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

}
