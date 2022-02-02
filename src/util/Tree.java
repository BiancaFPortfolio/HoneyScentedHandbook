package util;
import java.util.ArrayList;

public class Tree {
    String label;
    Tree[] nodes;
    String contents;

    public static void main(String[] args) {
        Tree t = new Tree(null);
        t.add(t, "bee", 0, "storage");
        t.add(t, "apple", 0, "kevin");
        t.add(t, "butter", 0, "allie");
        t.add(t, "zed", 0, "butter");
        //String s = t.remove(t, "bee", 0);
        //System.out.println(s);
        ArrayList<Tree> pr = t.traverse(new ArrayList<Tree>(), t);
        for(int i = 0; i < pr.size(); i++) {
            System.out.println(pr.get(i).label);
        }
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
            //Take integer and add string from character and beyond as content
            if(curr.nodes[charAt] == null) {
                curr.nodes[charAt] = new Tree(s.substring(0, index+1));
            }
            curr = curr.nodes[charAt];
            index += 1; 
            //Base case
            if(s.length() == index) {
                curr.contents = contents;
                return true;
            } else {
                return add(curr, s, index, contents);
            }
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //Pass in root node, s as the string to remove, and an index of 0 for recursion
    public String remove(Tree curr, String s, int index) {
        try {
            curr = curr.nodes[s.charAt(index)-97];
            index += 1;
            if(s.equals(curr.label)) {
                String con = curr.contents;
                curr.contents = null;
                return con;
            } else {
                return remove(curr, s, index);
            }
        } catch(Exception e) {
            //No character at that index
            System.out.println(e);
            return null;
        }
    }

    //Pass in empty arraylist, and root or desired subtree,
    public ArrayList<Tree> traverse(ArrayList<Tree> ret, Tree curr) {
        //Check if not root, because root has no label
        if(curr.label != null) {
            if(curr.contents != null) {
                ret.add(curr);
            }
        }
        for(int i = 0; i < curr.nodes.length; i++) {
            try {
                ret = traverse(ret, curr.nodes[i]);
            } catch(Exception e) {
                //Nothing to traverse
                continue;
            }
        }
        //Base case, return ret list
        return ret;
    }
}