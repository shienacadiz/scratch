package gfg.node;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TreeNodeTest {

    private TreeRightmost treeRightmost;

    @Before
    public void setUp() {
        treeRightmost = new TreeRightmost();
    }

    @Test
    public void testTreeRightmostAllRight() {
        TreeNode thirdLevelLeft = new TreeNode(40);
        TreeNode thirdLevelRight = new TreeNode(60);

        TreeNode secondLevelLeft = new TreeNode(20);
        TreeNode secondLevelRight = new TreeNode(30);
        secondLevelRight.left = thirdLevelLeft;
        secondLevelRight.right = thirdLevelRight;

        TreeNode firstLevel = new TreeNode(10);
        firstLevel.left = secondLevelLeft;
        firstLevel.right = secondLevelRight;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(30);
        expected.add(60);

        assertEquals(expected, treeRightmost.rightView(firstLevel));
    }

    @Test
    public void testTreeRightmostOneLevelOnly() {
        TreeNode firstLevel = new TreeNode(10);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10);

        assertEquals(expected, treeRightmost.rightView(firstLevel));
    }

    @Test
    public void testTreeRightmostValueOnLeft() {
        TreeNode secondLevelLeft = new TreeNode(20);
        TreeNode firstLevel = new TreeNode(10);
        firstLevel.left = secondLevelLeft;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(20);

        assertEquals(expected, treeRightmost.rightView(firstLevel));
    }

    @Test
    public void testTreeRightmostWithFurtherLevelOnLeft() {
        TreeNode thirdLevelLeft = new TreeNode(40);
        TreeNode thirdLevelRight = new TreeNode(60);

        TreeNode secondLevelLeft = new TreeNode(20);
        TreeNode secondLevelRight = new TreeNode(30);
        secondLevelLeft.left = thirdLevelLeft;
        secondLevelLeft.right = thirdLevelRight;

        TreeNode firstLevel = new TreeNode(10);
        firstLevel.left = secondLevelLeft;
        firstLevel.right = secondLevelRight;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(30);
        expected.add(60);

        assertEquals(expected, treeRightmost.rightView(firstLevel));
    }
}
