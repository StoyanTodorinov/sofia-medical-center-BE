package com.hospital.app.utils;

public class Algorithms {

	/**
	 * Calculates the likelihood of human to have genetic disorder based on the DNA.
	 *
	 * @param dna – human dna to be checked
	 * @return a number between 0 and 1 with the probability for disorder
	 */
	public static double getGeneticDisorderProbability(String dna) {

		int longestSequenceLength = 0;
		int SIZE = dna.length();

		/**
		 * Loop through the DNA sequence from the last character to the first (reversed)
		 */
		for (int i = SIZE - 1; i >= 0; i--) {

			/**
			 * The longest sequence found is bigger than the remaining characters to check,
			 * break the loop
			 */
			if (longestSequenceLength > i + 1) {
				break;
			}
			int currentIndex = i;
			/**
			 * Check if the current character is the same as the first character in the DNA
			 * sequence
			 */
			if (dna.charAt(0) == dna.charAt(i)) {
				int sequenceLength = 1;
				/**
				 * Loop ahead through the sequence and find the whole matching sequence
				 */
				while (true) {
					/**
					 * In case we find another starting point to our while loop, adjust the index of
					 * the for loop in order to avoid unnecessary operations, do this only once due
					 * to the risk of skipping potential sequences
					 */
					if (i == currentIndex && i - sequenceLength > 0
							&& dna.charAt(i - sequenceLength) == dna.charAt(0)) {
						i = i - sequenceLength;
					}
					/**
					 * Check if we have reached the end of the matching sequence or the end of the
					 * DNA sequence.
					 * 
					 * 1. Update the longest sequence length if greater than the previous one and
					 * break the loop
					 * 
					 * 2. Otherwise add 1 to the current matching sequence length
					 */
					if (currentIndex - sequenceLength < 0
							|| dna.charAt(currentIndex - sequenceLength) != dna.charAt(sequenceLength)) {
						if (sequenceLength > longestSequenceLength) {
							longestSequenceLength = sequenceLength;
						}
						break;
					} else {
						sequenceLength++;
					}
				}
			}
		}

		/* Find one percent of the DNA size */
		double onePercentOfSize = SIZE * 0.01;
		/* Find point two percent of the DNA size */
		double pointTwoPercentOfSize = SIZE * 0.002;

		if (longestSequenceLength < pointTwoPercentOfSize) {
			return 0;
		} else if (longestSequenceLength > onePercentOfSize) {
			return 1;
		} else {
			return ((longestSequenceLength * 1.0) / SIZE) * 100;
			/**
			 * The email said that the calculation must be done in this matter, however this
			 * calculation creates too big of a gap between 0 and 1
			 */
			// return (longestSequenceLength * 1.0) / SIZE;
		}
	}
}
