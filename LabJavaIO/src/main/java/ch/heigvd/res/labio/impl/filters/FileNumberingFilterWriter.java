package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * This class transforms the streams of character sent to the decorated writer.
 * When filter encounters a line separator, it sends it to the decorated writer.
 * It then sends the line number and a tab character, before resuming the write
 * process.
 *
 * Hello\n\World -> 1\Hello\n2\tWorld
 *
 * @author Olivier Liechti
 */
public class FileNumberingFilterWriter extends FilterWriter {

	private static final Logger LOG = Logger.getLogger(FileNumberingFilterWriter.class.getName());

	private Integer lineCounter;
	private boolean complexChar;

	public FileNumberingFilterWriter(Writer out) {
		super(out);
		lineCounter = 0;
		complexChar = false;
	}

	@Override
	public void write(String str, int off, int len) throws IOException {

		// Modifie par Rémy Vuagniaux pour le Labo 2 RES

		String temp = str.substring(off, off + len);

		for (int i = 0; i < temp.length(); i++) {
			this.write(temp.charAt(i));
		}

		// throw new UnsupportedOperationException("The student has not implemented this
		// method yet.");
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {

		// Modifie par Rémy Vuagniaux pour le Labo 2 RES

		for (int i = off; i < len + off; i++) {
			this.write(cbuf[i]);
		}

		// throw new UnsupportedOperationException("The student has not implemented this
		// method yet.");
	}

	@Override
	public void write(int c) throws IOException {

		// Modifie par Rémy Vuagniaux pour le Labo 2 RES

		// Si on est a la premeiere ligne on ecrit le numero meme si il n'y a pas de
		// retoru a la ligne
		if (lineCounter == 0) {
			this.out.write((++lineCounter).toString());
			this.out.write((int) '\t');
		}

		// On regarde si on a le caractere \r
		if ((char) c == '\r') {
			complexChar = true;
			this.out.write(c);
		} else if ((char) c == '\n') {

			this.out.write(c);
			this.out.write((++lineCounter).toString());
			this.out.write((int) '\t');
			complexChar = false;

		} else {

			if (complexChar) {
				this.out.write((++lineCounter).toString());
				this.out.write((int) '\t');
				this.out.write(c);
				complexChar = false;
			} else {
				this.out.write(c);
			}
		}
		// throw new UnsupportedOperationException("The student has not implemented this
		// method yet.");
	}

}
