
package creatures;

import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends Creature {

    private int r;
    private int g;
    private int b;

    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    @Override
    public void move() {
        energy = Math.max(energy - 0.03, 0);
    }

    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    @Override
    public Clorus replicate() {
        Clorus off = new Clorus(energy * 0.5);
        energy *= 0.5;
        return off;
    }

    @Override
    public void stay() {
        energy = Math.max(energy - 0.01, 0);
    }

    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();
        //boolean anyPlip = false;
        // (Google: Enhanced for-loop over keys of NEIGHBORS?)
        // for () {...}
        for (Map.Entry<Direction, Occupant> entry: neighbors.entrySet()) {
            if (entry.getValue().name() == "plip") {
                plipNeighbors.addLast(entry.getKey());
            } else if (entry.getValue().name() == "empty") {
                emptyNeighbors.addLast(entry.getKey());
            }
        }

        if (emptyNeighbors.size() == 0) {
            return new Action(Action.ActionType.STAY);
        } else if (plipNeighbors.size() >= 1) {
            return new Action(Action.ActionType.ATTACK, randomEntry(plipNeighbors));
        } else if (this.energy() >= 1.0) {
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        }

        return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
    }

    @Override
    public Color color() {
        g = 0;
        r = 34;
        b = 231;
        return color(r, g, b);
    }
}

