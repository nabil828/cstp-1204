package permutationcipher;

public class PermutationCipher {

    /**
     * Encrypts a string by generating a permutation of the characters in the
     * string. The permutation is specified by permutationArray and the
     * characters may be permuted more than once depending on the number of
     * rounds indicated.
     * 
     * @param plaintext
     *            the text to encrypt.
     * @param permutationArray
     *            the array the specifies how to permute the plain text. A
     *            suitable permutation array must be equal in length to the
     *            plain text and must be a permutation of integers in [0 ..
     *            permutationArray.length-1].
     * @param rounds
     *            the number of rounds of encryption needed; rounds should be at
     *            least 1.
     * @return the encrypted text (ciphertext).
     * @throws IllegalKeyException
     *             if the permutation array is not suitable.
     */
    public static String encrypt(String plaintext, int[] permutationArray, int rounds) throws IllegalKeyException {
        // TODO: Implement this methods
        char[] resultArr = new char[plaintext.length()];
        if (rounds < 1) {
            throw new IllegalKeyException();
        }
        
        char[] temp =  plaintext.toCharArray();

        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < permutationArray.length; j++) {
                resultArr[permutationArray[j]] = temp[j];
            }
            System.arraycopy( resultArr, 0, temp, 0, resultArr.length );            
        }

        // for(int i = 0; i < resultArr.length / 2; i++)
        // {
        // char temp = resultArr[i];
        // resultArr[i] = resultArr[resultArr.length - i - 1];
        // resultArr[resultArr.length - i - 1] = temp;
        // }

        String text = String.copyValueOf(resultArr);
        ;
        return text;
    }

}
