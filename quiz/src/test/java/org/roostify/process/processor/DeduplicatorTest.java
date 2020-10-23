package org.roostify.process.processor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DeduplicatorTest {
    static Set<String> set  = new HashSet<String>() { {
        add("a");
        add("b");
        add("c");
        add("d");
        add("e");
    }
    };
    String s;
    Deduplicator deduplicator;
    @Before
    public void setUp() throws Exception {
       s = "c";
       deduplicator = new Deduplicator();
    }

    @Test
    public void remove() {
        Assert.assertEquals(set.size(), 5);
        String[] r = deduplicator.process(set, s);
        Assert.assertEquals(r.length, 4);

    }
}