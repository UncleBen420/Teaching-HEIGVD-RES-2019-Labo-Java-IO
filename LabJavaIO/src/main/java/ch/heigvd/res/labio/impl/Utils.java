package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

	private static final Logger LOG = Logger.getLogger(Utils.class.getName());

	/**
	 * This method looks for the next new line separators (\r, \n, \r\n) to extract
	 * the next line in the string passed in arguments.
	 * 
	 * @param lines a string that may contain 0, 1 or more lines
	 * @return an array with 2 elements; the first element is the next line with the
	 *         line separator, the second element is the remaining text. If the
	 *         argument does not contain any line separator, then the first element
	 *         is an empty string.
	 */
	public static String[] getNextLine(String lines) {

		// Modifie par Rémy Vuagniaux pour le Labo 2 RES

		String[] temp = { "", "" };
		int index = 0;

		temp[1] = lines;

		index = lines.indexOf('\r');

		if (lines.indexOf('\n') >= 0) {
			index = lines.indexOf('\n');
		}

		temp[0] = lines.substring(0, ++index);
		temp[1] = lines.substring(index);

		return temp;

		// throw new UnsupportedOperationException("The student has not implemented this
		// method yet.");
	}

}
