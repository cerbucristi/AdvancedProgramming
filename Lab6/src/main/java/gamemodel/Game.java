package gamemodel;

import graphic.DrawingPanel;
import org.javatuples.Pair;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    List<Line> lines;
    Map<Pair<Integer, Integer>, Vertice> vertices;

    Set<Line> coloredLines;

    int turn;

    public Game() {
        lines = new ArrayList<>();
        vertices = new HashMap<>();
        coloredLines = new HashSet<>();
        turn = 1;
    }

    public void checkAndColorLine(DrawingPanel drawingPanel, Vertice vertice){
        Color color;
        for (Line line : lines) {
            if (line.containsVertice(vertice) && !coloredLines.contains(line)) {
                color =  turn % 2 == 0 ? Color.BLUE : Color.RED;
                drawingPanel.drawLineWithColor(line, color);
                line.setColor(color);
                coloredLines.add(line);
                turn ++;
                if (isGameFinished(color)) {
                    drawingPanel.finishGame();
                }
            }
        }
    }

    private boolean isGameFinished (Color color) {
        List<Line> colorLines = coloredLines.stream().filter(e -> e.getColor().equals(color)).collect(Collectors.toList());
        Set<Vertice> vertices = new HashSet<>();
        for (Line line : colorLines) {
            vertices.add(line.getVertice1());
            vertices.add(line.getVertice2());
        }
        return vertices.size() == 3 && colorLines.size() >= 3;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Map<Pair<Integer, Integer>, Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(Map<Pair<Integer, Integer>, Vertice> vertices) {
        this.vertices = vertices;
    }
}
