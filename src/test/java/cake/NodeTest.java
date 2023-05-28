package cake;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NodeTest {

    @Test
    public void sampleTest() {
        Node leaf1 = new Node(null, null);
        Node leaf2 = new Node(null, null);
        Node node = new Node(leaf1, null);
        Node root = new Node(node, leaf2);

        assertThat(root.height(), is(3));
        assertThat(leaf1.height(), is(1));
    }

    @Test
    public void happyPathOne() {
        Node leafAAA = new Node(null, null);
        Node leafAAAAA = new Node(null, null);
        Node nodeAAAA = new Node(leafAAAAA, null);
        Node nodeAAA = new Node(null, nodeAAAA);
        Node nodeAA = new Node(nodeAAA,leafAAA);
        Node leafBBB = new Node(null, null);
        Node nodeBB = new Node(leafBBB, leafBBB);
        Node rootA = new Node(nodeAA, nodeBB);

        assertThat(rootA.height(), is(5));
        assertThat(nodeAA.height(), is(4));
        assertThat(nodeAAAA.height(), is(2));
        assertThat(leafAAA.height(), is(1));
    }

    @Test
    public void happyPathTwo() {
        Node leafBBBBBBB = new Node(null, null);
        Node nodeBBBBBB = new Node(null, leafBBBBBBB);
        Node leafBBBBBB = new Node(null, null);
        Node nodeBBBBB = new Node(leafBBBBBB, nodeBBBBBB);
        Node leafBBBBB = new Node(null, null);
        Node nodeBBBB = new Node(nodeBBBBB, leafBBBBB);
        Node nodeBBB = new Node(nodeBBBB, null);
        Node leafBBB = new Node(null, null);
        Node nodeBB = new Node(nodeBBB, leafBBB);

        Node leafAAAA = new Node(null, null);
        Node nodeAAA = new Node(leafAAAA, leafAAAA);
        Node leafAAA = new Node(null, null);
        Node nodeAA = new Node(nodeAAA, leafAAA);
        Node rootA = new Node(nodeAA, nodeBB);

        assertThat(rootA.height(), is(7));
    }
}