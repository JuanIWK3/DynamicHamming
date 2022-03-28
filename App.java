public class App {

    public static boolean isPowerOfTwo(int n) {
        return (int) (Math.ceil(Math.log(n) / Math.log(2))) == (int) (Math.floor(Math.log(n) / Math.log(2)));
    }

    public static void main(String[] args) throws Exception {
        boolean[] bits = { false, true, false, false, false, false, false, true };
        int qtndPowers = 0;

        // Definir a quantidade de potências de 2
        for (int i = 0; i < bits.length; i++) {
            if (isPowerOfTwo(i)) {
                qtndPowers++;
            }
        }

        int[] powers = new int[qtndPowers];

        boolean[] bitsWithHamming = new boolean[bits.length + powers.length];

        for (int i = 0; i < powers.length; i++) {
            powers[i] = (int) Math.pow(2, i);
        }

        boolean[] hammingBits = new boolean[powers.length];

        // Para cada potência de 2
        for (int i = 0; i < powers.length; i++) {
            int count = powers[i]; // Começar na casa correta
            System.out.println("Bits verificados no h" + (powers[i] - 1));
            boolean xor = false;

            // Para ler todos os números
            while (count <= bits.length + 1) {
                // Ler a quantidade powers[i] de casas
                for (int j = 0; j < powers[i]; j++) {
                    if (i == 3) {
                        System.out.println("=========");
                        System.out.println(count - 1);
                        System.out.println("=========");
                    }
                    // Para não ler mais que o existente
                    if (count < bits.length) {
                        System.out.print(count - 1 + " ");
                        // Calcular o valor do bit de hamming
                        xor = xor ^ bits[count];
                    }
                    count++;
                }
                // Pular a quantidade powers[i] de casas
                for (int j = 0; j < powers[i]; j++) {
                    count++;
                }
            }
            hammingBits[i] = !xor;
            System.out.println();
        }

        System.out.println("Hamming Bits");
        for (int i = 0; i < hammingBits.length; i++) {
            System.out.print(hammingBits[i] ? 1 + " " : 0 + " ");
        }
        System.out.println();

        System.out.println();

        int bitsCount = 0;
        int hammingBitsCount = 0;

        // Preencher o novo array
        for (int i = 0; i < bitsWithHamming.length; i++) {
            // Se a posi for uma potência de dois, bit de hamming

            if (isPowerOfTwo(i + 1) && hammingBitsCount != hammingBits.length) {
                System.out.println(i + " hamming");
                bitsWithHamming[i] = hammingBits[hammingBitsCount];
                hammingBitsCount++;
            } else {
                if (bitsCount != bits.length) {
                    System.out.println(i);
                    bitsWithHamming[i] = bits[bitsCount];
                    bitsCount++;
                }
            }

        }

        System.out.println();
        System.out.println("bits");

        for (int i = 0; i < bits.length; i++) {
            System.out.print(bits[i] ? 1 : 0);
        }

        System.out.println();
        System.out.println("bits with hamming");

        for (int i = 0; i < bitsWithHamming.length; i++) {
            System.out.print(bitsWithHamming[i] ? 1 : 0);
        }
    }

}
