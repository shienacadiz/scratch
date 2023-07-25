package gfg.node;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TreeSpiralTest {

    private TreeSpiral treeSpiral;

    @Before
    public void setUp() {
        treeSpiral = new TreeSpiral();
    }

    @Test
    public void testSpiral() {
        TreeNode thirdLevelFirstNodeLeft = new TreeNode(7);
        TreeNode thirdLevelFirstNodeRight = new TreeNode(6);
        TreeNode thirdLevelSecondNodeLeft = new TreeNode(5);
        TreeNode thirdLevelSecondNodeRight = new TreeNode(4);
        TreeNode secondLevelFirstNodeLeft = new TreeNode(2, thirdLevelFirstNodeLeft, thirdLevelFirstNodeRight);
        TreeNode secondLevelFirstNodeRight = new TreeNode(3, thirdLevelSecondNodeLeft, thirdLevelSecondNodeRight);
        TreeNode firstLevelRootNode = new TreeNode(1, secondLevelFirstNodeLeft, secondLevelFirstNodeRight);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(expected, treeSpiral.findSpiral(firstLevelRootNode));
    }

    @Test
    public void testSpiralOnlyOneNode() {
        TreeNode firstLevelRootNode = new TreeNode(1);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1));
        assertEquals(expected, treeSpiral.findSpiral(firstLevelRootNode));
    }
}
