package com.crazybunqnq.leetcode.algorithm.hard;

/**
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
 * <p>
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
 * <p>
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 * <p>
 * We are given a list A of unique strings.  Every string in A is an anagram of every other string in A.  How many groups are there?
 * <p>
 * Example 1:
 * <p>
 * Input: ["tars","rats","arts","star"]
 * Output: 2
 * Note:
 * <p>
 * A.length <= 2000
 * A[i].length <= 1000
 * A.length * A[i].length <= 20000
 * All words in A consist of lowercase letters only.
 * All words in A have the same length and are anagrams of each other.
 * The judging time limit has been increased for this question.
 *
 * @version 2018/5/20.
 * @Score 10
 * @auther CrazyBunQnQ
 */
public class SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        return 0;
    }
}
