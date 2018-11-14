package ru.chedmitriy.datatypes;

/**
 * Class ChangeState
 * @author dimCher
 * @since 22.05.2016.
 */

public class ChangeTask {

   public static class Claim {
        public  String name;
    }
    public static void main(String[] args) {
        /**
         * @param claim -
         * @param claim.name = "bug"-
         */
        Claim claim = new Claim();
        claim.name = "bug";
        processClaim(claim);
        System.out.println(claim.name);
    }
    /**
     *  processClaim -  Claim
     *  "task".
     * */
    private static void processClaim(Claim value) {

        value.name = "task";
    }
}
 