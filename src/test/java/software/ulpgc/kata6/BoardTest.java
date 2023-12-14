package software.ulpgc.kata6;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void should_return_empty_board_given_empty_board() {
        Board board = new Board("").next();
        assertThat(board.state()).isEqualTo("");
    }

    @Test
    public void should_return_1x1_board_with_all_dead_cells_given_1x1_board(){
        Board board = new Board(".").next();
        assertThat(board.state()).isEqualTo(".");
    }

    @Test
    public void should_return_1x1_board_with_all_dead_cells_given_1x1_board_with_one_alive_cell() {
        Board board = new Board("X").next();
        assertThat(board.state()).isEqualTo(".");
    }

    @Test
    public void should_return_2x2_board_with_all_alive_cells_given_2x2_board_with_all_alive_cells() {
        Board board = new Board(Cases.board2x2_with_all_alive_cells).next();
        assertThat(board.state()).isEqualTo(Cases.board2x2_with_all_alive_cells);
    }

    @Test
    public void  should_return_2x2_board_with_all_alive_cell_given_2x2_board_with_triangle_structure() {
        Board board = new Board(Cases.board2x2_with_triagle_structure).next();
        assertThat(board.state()).isEqualTo(Cases.board2x2_with_all_alive_cells);
    }

    @Test
    public void should_return_2x2_board_with_all_dead_cell_give_2x2_board_with_strip_structure() {
        Board board = new Board(Cases.board2x2_with_strip_structure).next();
        assertThat(board.state()).isEqualTo(Cases.board2x2_with_all_dead_cells);
    }

    public static class Cases {
        static final String board2x2_with_all_dead_cells = """
                ..
                ..
                """.trim();

        static final String board2x2_with_all_alive_cells = """
                XX
                XX
                """.trim();

        static final String board2x2_with_triagle_structure = """
                .X
                XX
                """.trim();

        static final String board2x2_with_strip_structure = """
                ..
                XX
                """.trim();
    }


}