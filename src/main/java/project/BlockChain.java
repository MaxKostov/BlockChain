package project;

public class BlockChain {

    public static void main(String[] args) {

        Block genesisBlock = new Block("First block", "0");
        System.out.println("Hash for block 1: " + genesisBlock.getHash());

        Block secondBlock = new Block("Second block", genesisBlock.getHash());
        System.out.println("Hash for block 2: " + secondBlock.getHash());

        Block thirdBlock = new Block("Third block", secondBlock.getHash());
        System.out.println("Hash for block 3: " + thirdBlock.getHash());

    }
}
