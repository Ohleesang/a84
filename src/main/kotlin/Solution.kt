/**
 * 1~1000  s : 들어오는 괄호 문자열
 * [],{},() 가 있는 s가 들어온다.
 * 이때 A가 올바른 문자열이면 [A],{A},(A) 도 올바른 문자열이다.
 *
 * 들어온 s을 회전 시켜서,
 * 올바른 괄호 문자열의 수를 return
 */

import java.util.Stack

const val BIG ="[]"
const val MIDDLE ="{}"
const val SMALL ="()"

class Solution {
    // 한칸씩 미루는 함수(<<)
    fun pushStr(s: String):String{
        var answer =""

        //List 로 치환 이후,마지막 인자값을 첫번째로 옮긴다.
        var list = s.toMutableList()
        var first_char = s.first()
        list.removeFirst()
        list.add(first_char)
        answer = StringBuilder().append(list.toCharArray()).toString()
        return answer
    }

    // 올바른 괄호인지 판별하는 함수
    fun goodBracket(s: String):Boolean{
        var answer = true
        //스택으로 만들어서 만약 스택값이 비어있으면 올바른 괄호
        var stack = Stack<Char>()
        //이때 문자열 갯수만 반복하는게 아니라 다시 recount해야한다!
//        for(i in 1..s.lastIndex){
//            stack.push(s[i])
//            //괄호가 맞냐 판별
//            if(isBracket(s[i-1],s[i])){
//                //올바른 괄호가있으면 stack 에서 빼자
//                stack.pop()
//                stack.pop()
//            }
//        }
        var index = 0
        var listStr = s.toMutableList()
        //list 값에서 올바른 문자열 괄호가 만들어질떄,같이 제거하고 만약 stack이랑 크기같아지면 break?
        while(stack.size!=listStr.size){
            stack.push(listStr[index])
            if(index==0) {
                index++
                continue
            }
            //괄호가 맞냐 판별
            if(isBracket(listStr[index-1],listStr[index])){
                //올바른 괄호가 있으면 stack에서 빼자
                stack.pop()
                listStr.removeAt(index--)
                stack.pop()
                listStr.removeAt(index--)
            }
            index++

        }
        if(stack.isNotEmpty()) answer = false

        return answer
    }

    //두 문자를 합쳐서 괄호가 되는가?
    fun isBracket(c1:Char,c2:Char):Boolean{
        var answer = false
        var s= c1.toString() + c2.toString()
        if(s==BIG) answer = true
        if(s==MIDDLE) answer = true
        if(s==SMALL) answer = true

        return answer
    }


    fun solution(s: String): Int {
        var answer: Int = 0
        var str = s
        var list = mutableMapOf<String,Boolean>()
        for(i in 1..s.length){
            if(goodBracket(str)) answer++
            list.put(str,goodBracket(str))
            str = pushStr(str)
        }
        return answer
    }
}
fun main(){
    var a = Solution()

    a.solution("[](){}")//3
    a.solution("}]()[{")//2
    a.solution("[)(]")//0
    a.solution("}}}")//0
}