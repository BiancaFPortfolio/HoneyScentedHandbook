package util;

public class Tree {
    String label;
    Tree[] nodes;
    String contents;

    public static void main(String[] args) {
        Tree t = new Tree("0");
        t.add(t, "bee", 0, "storage");
    }

    public Tree(String item) {
        label = item;
        nodes = new Tree[26];
    }

    //Pass in root Tree node, desired term as s, index of 0 for recursion purposes, and String contents
    public boolean add(Tree curr, String s, int index, String contents) {
        try {
            //Find current character
            char chara = s.charAt(index);
            //Convert character to integer
            int charAt = ((int) chara) - 97;
            System.out.println(chara);
            System.out.println(charAt);
            //Take integer and add string from character and beyond as content
            if(curr.nodes[charAt] == null) {
                curr.nodes[charAt] = new Tree(s.substring(0, index));
            }
            curr = curr.nodes[charAt];
            index += 1; 
            //Base case
            if(s.length() == index) {
                curr.contents = contents;
                System.out.println(contents);
                return true;
            } else {
                return add(curr, s, index, contents);
            }
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
}