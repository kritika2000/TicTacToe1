package com.example.tictactoe1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var player : Boolean = true
    var board : Array<Array<String>> = arrayOf(
        arrayOf(),
        arrayOf(),
        arrayOf()
    )
    private fun checkWinner(board : Array<Array<String>>){
        var count=0
        var k=0
        for(i in 0..2){
            for(j in 0..2){
                if(board[i][j]=="-1"){
                    count++
                }
                else
                    k++
            }
        }
        if(count==9)
            return
        //diagonal
        var ans : String = ""
        if(board[0][0]==board[1][1]&&board[0][0]==board[2][2]){
            ans=board[0][0]
            if(!ans.equals("-1")) {
                tv.text = "Player $ans Win"
                return
            }
        }
        if(board[0][2]==board[1][1]&&board[0][2]==board[2][0]){
            ans=board[0][2]
            if(!ans.equals("-1")) {
                tv.text = "Player $ans Win"
                return
            }
        }
        //rows
        if(board[0][0]==board[0][1]&&board[0][0]==board[0][2]){
            ans=board[0][0]
            if(!ans.equals("-1")) {
                tv.text = "Player $ans Win"
                return
            }
        }
        if(board[1][0]==board[1][1]&&board[1][0]==board[1][2]){
            ans=board[1][0]
            if(!ans.equals("-1")) {
                tv.text = "Player $ans Win"
                return
            }
        }
        if(board[2][0]==board[2][1]&&board[2][0]==board[2][2]){
            ans=board[2][0]
            if(!ans.equals("-1")) {
                tv.text = "Player $ans Win"
                return
            }
        }
        //columns
        if(board[0][0]==board[1][0]&&board[0][0]==board[2][0]){
            ans=board[0][0]
            if(!ans.equals("-1")) {
                tv.text = "Player $ans Win"
                return
            }
        }
        if(board[0][1]==board[1][1]&&board[0][1]==board[2][1]){
            ans=board[0][1]
            if(!ans.equals("-1")) {
                tv.text = "Player $ans Win"
                return
            }
        }
        if(board[0][2]==board[1][2]&&board[0][2]==board[2][2]) {
            ans = board[0][2]
            if (!ans.equals("-1")) {
                tv.text = "Player $ans Win"
                return
            }
        }
        if(k==9) {
            tv.text = "Draw"
            return
        }

    }
    private fun reset_board(button:Array<Array<Button>>, board : Array<Array<String>>){
        for(i in 0..2){
            for(j in 0..2){
                button[i][j].text=""
                board[i][j]="-1"
                button[i][j].isEnabled=true
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button : Array<Array<Button>> = arrayOf(
            arrayOf(btn00,btn01,btn02),
            arrayOf(btn10,btn11,btn12),
            arrayOf(btn20,btn21,btn22)
        )
        board = arrayOf(
            arrayOf("-1","-1","-1"),
            arrayOf("-1","-1","-1"),
            arrayOf("-1","-1","-1")
        )
        reset.setOnClickListener {
            reset_board(button, board)
            tv.hint="Result"
            tv.text=""
            player=true
        }
        for(i in 0..2){
            for(j in 0..2){
                button[i][j].setOnClickListener {
                    if(player) {
                        button[i][j].text = "O"
                        board[i][j]="O"
                        checkWinner(board)
                    }
                    else {
                        button[i][j].text = "X"
                        board[i][j]="X"
                        checkWinner(board)
                    }
                    player=!player
                    button[i][j].isEnabled=false
                }
            }
        }
        checkWinner(board)
    }
}
