package com.lgt;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ZoneTreeTest extends TestCase {
    ZoneTree zt = new ZoneTree();

    @Before
    public void setup() {
        zt.addNode(new Node("中国",""));
        zt.addNode(new Node("湖北","42"));
        zt.addNode(new Node("武汉市","4201"));
        zt.addNode(new Node("江岸区","420102"));
    }

    @Test
    public void testAddNode() throws Exception {
        zt.addNode(new Node("宜昌市","4205"));
        zt.addNode(new Node("点军区","420504"));
        Node n = zt.findNode(zt.getRoot(),"点军区");
        assertEquals("420504",n.getData());
    }

    @Test
    public void testFindNode() throws Exception {

    }
}