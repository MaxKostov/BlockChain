package project;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class BlockChain {

    public static ArrayList<Block> blockChain = new ArrayList<Block>();

    public static int difficulty = 5;

    public static void main(String[] args) {

        blockChain.add(new Block("First block", "0"));
        System.out.println("Trying to mine block 1...");
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block("Second block", blockChain.getLast().getHash()));
        System.out.println("Trying to mine block 2...");
        blockChain.get(1).mineBlock(difficulty);

        blockChain.add(new Block("Third block", blockChain.getLast().getHash()));
        System.out.println("Trying to mine block 3...");
        blockChain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println("The blockchain: ");
        System.out.println(blockchainJson);
    }

    public static boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        if (blockChain.isEmpty()) {
            System.out.println("Chain is empty");
            return false;
        }

        if (!blockChain.getFirst().getHash().equals(blockChain.getFirst().calculateHash())) {
            System.out.println("Chain is not valid");
            return false;
        }

        for (int i = 1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i - 1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes don't match");
                return false;
            }

            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hashes don't match");
                return false;
            }
        }
        return true;
    }
}
