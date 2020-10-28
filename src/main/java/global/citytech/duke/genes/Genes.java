package global.citytech.duke.genes;

import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Genes {
    private String dnaString;
    private ArrayList<String> dnaGenesList;
    private ArrayList<Float> dnaGenesCGRatioList;

    public Genes(String dnaString) {
        this.dnaString = dnaString;
        dnaGenesList = new ArrayList<String>();
        dnaGenesCGRatioList = new ArrayList<Float>();
        processDNA();
    }

    public void testingForTDD() {
        throw new IllegalArgumentException("initial_test");
    }

    private int getStartingPositionOfGene(int checker) {
        return dnaString.indexOf("ATG", checker);
    }

    private int getEndingPositionOfGene(int checker, String checkerClosingCodon) {
//        TAA || TAG || TGA
        System.out.println("=======================================+>checker" + checker);
        int workingChecker = checker;
        int minIndex = -1;
        while (true) {
            int foundIndex = dnaString.indexOf(checkerClosingCodon, workingChecker);
            System.out.println("workingChecker=" + workingChecker + "found->" + foundIndex);
            if (foundIndex == -1) {
                minIndex = foundIndex;
                break;
            } else {
                System.out.println("checker" + checker + "found===>" + checkerClosingCodon + "===>" + foundIndex);
                if ((checker - foundIndex) % 3 == 0) {
                    minIndex = foundIndex;
                    break;
                } else {
                    workingChecker = foundIndex + 2;
                }
            }
        }
        return minIndex;
    }

    private int minIndex(int one, int two, int three) {
        if (one > -1) {
            if (two > -1) {
                if (three > -1) {
                    if (one < two && one < three) {
                        return one;
                    } else if (two < one && two < three) {
                        return two;
                    } else {
                        return three;
                    }
                } else {
                    if (one < two) {
                        return one;
                    } else {
                        return two;
                    }
                }
            } else {
                if (three > -1) {
                    if (one < three) {
                        return one;
                    } else {
                        return three;
                    }
                } else {
                    return one;
                }
            }
        } else {
            if (two > -1) {
                if (three > -1) {
                    if (two < three) {
                        return two;
                    } else {
                        return three;
                    }
                } else {
                    return two;
                }
            } else {
                if (three > -1) {
                    return three;
                } else {
                    return -1;
                }
            }
        }
//        return -1;
    }

    private void processDNA() {
        int checker = 0;
        int minIndex = 0;
        String temp;
        while (true) {
            int startingATG = getStartingPositionOfGene(checker);
            if (startingATG != -1) {
                checker = startingATG;
                int startingTAA = getEndingPositionOfGene(checker, "TAA");
                int startingTGA = getEndingPositionOfGene(checker, "TGA");
                int startingTAG = getEndingPositionOfGene(checker, "TAG");
                minIndex = minIndex(startingTAA, startingTGA, startingTAG);
                System.out.println(this.dnaString.substring(startingATG));
                System.out.println("checker=" + checker);
                System.out.println("startingATG=" + startingATG);
                System.out.println("startingTAA="+startingTAA);
                System.out.println("startingTGA="+startingTGA);
                System.out.println("startingTAG="+startingTAG);
                System.out.println("min" + minIndex);
                if (minIndex != -1) {
//                    System.out.println("startingAAT" + minIndex);
                    temp = this.dnaString.substring(startingATG, minIndex + 3);
//                    System.out.println("temp" + temp);
                    if ((temp.length()) % 3 == 0) {
                        checker = minIndex + 2;
                        this.dnaGenesList.add(temp);
                        this.dnaGenesCGRatioList.add(getCGRatio(temp));
//                        System.out.println("checker" + checker);
                        System.out.println("acc temp==>" + temp);
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public int getNumberOfGenes() {
        int temp = 0;
        for (String word : dnaGenesList) {
            if (word.length() > 6) {
                temp++;
            }
        }
        return temp;
    }

    private float getCGRatio(String gene) {
//        System.out.println(gene);
        String[] allC = Pattern.compile("C")
                .matcher(gene)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        String[] allG = Pattern.compile("G")
                .matcher(gene)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
//        System.out.println(allC.length+"   "+allG.length);
        return (float) (allC.length + allG.length) / gene.length();
    }

    public int getNumbersOfCodon(String checkerCodon) {
        String[] matches = Pattern.compile(checkerCodon)
                .matcher(dnaString)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);

        return matches.length;
    }

    public int getNumbersOfCodon(String checkerCodon, String dnaTester) {
        String[] matches = Pattern.compile(checkerCodon)
                .matcher(dnaTester)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);

        return matches.length;
    }

    public int getNumbersOfGenesGreaterThanLimiter(int limiter) {
        int temp = 0;
        for (String word : dnaGenesList) {
            if (word.length() > 60) {
                temp++;
            }
        }
        return temp;
    }

    public int getLongestGenes() {
        int temp = 0;
        for (String word : dnaGenesList) {
            if (word.length() > temp) {
                temp = word.length();
            }
        }
        return temp;
    }

    public int getNumberOfGenesByCGRatioLimiter(float CGRatioLimiter) {
        int temp = 0;
        for (float cgRatio : dnaGenesCGRatioList) {
            if (cgRatio > CGRatioLimiter) {
                temp++;
            }
        }
        return temp;

    }

    public void testingParts(int from, String word) {
        String[] matches = Pattern.compile("[A-Za-z]{3}")
                .matcher(word.substring(from))
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        int temp = 0;
        for (String tmp : matches) {
            System.out.println(temp * 3 + ". " + tmp);
            temp++;
        }
    }
}
