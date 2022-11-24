package Exams.Midterm.ValidatingHTML.srcMark;

import java.util.*;

/*
 * This is the HtmlValidator class.
 * You should implement this class.
 */
public class HtmlValidator {
    private Stack<HtmlTag> stack;
    private Queue<HtmlTag> queue;

    public HtmlValidator() {
        queue = new LinkedList<HtmlTag>();
    }

    public HtmlValidator(Queue<HtmlTag> tags) {
        if (tags == null) {
            throw new IllegalArgumentException();
        }
        queue = new LinkedList<HtmlTag>();
        Queue<HtmlTag> TempQueue = new LinkedList<HtmlTag>();
        for (HtmlTag tag : tags) {
            TempQueue.add(tag);
        }
        for (HtmlTag tag : TempQueue) {
            queue.add(tag);
        }
    }

    public void addTag(HtmlTag tag) {
        if (tag == null) {
            throw new IllegalArgumentException();
        }
        queue.add(tag);
    }

    public Queue<HtmlTag> getTags() {
        Queue<HtmlTag> result = new LinkedList<HtmlTag>();
        Queue<HtmlTag> TempQueue = new LinkedList<HtmlTag>();
        for (HtmlTag tag : queue) {
            TempQueue.add(tag);
        }
        for (HtmlTag tag : TempQueue) {
            result.add(tag);
        }
        return result;
    }

    public void removeAll(String element) {
        for (HtmlTag tag : queue) {
            if (tag.getElement().equals(element)) {
                queue.remove(tag);
            }
        }
    }

    public void validate() {
        stack = new Stack<HtmlTag>();
        int indentations = 0;
        for (HtmlTag tag : queue) {
            if (!tag.isSelfClosing()) {
                if (tag.isOpenTag()) {
                    stack.push(tag);
                    indentations++;
                    for (int i = 0; i < indentations; i++) {
                        System.out.print("    ");
                    }
                    System.out.println(tag);
                } else {
                    if (stack.isEmpty()) {
                        System.out.println("Error: " + tag);
                    } else {
                        if (stack.peek().getElement().equals(tag.getElement())) {
                            for (int i = 0; i < indentations; i++) {
                                System.out.print("    ");
                            }
                            System.out.println(tag);
                            stack.pop();
                            indentations--;
                        } else {
                            System.out.println("Error: " + tag);
                        }
                    }
                }
            } else {
                for (int i = 0; i < indentations; i++) {
                    System.out.print("    ");
                }
                System.out.println(tag);
            }
        }
        if (!stack.isEmpty()) {
            Stack<String> errorStack = new Stack<>();
            for (HtmlTag tag : stack) {
                errorStack.add(tag.getElement());
            }
            while (!errorStack.isEmpty()) {
                System.out.println("Error Unclosed Tag: " + errorStack.pop());
            }
        }
    }
}