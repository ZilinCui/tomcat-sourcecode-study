package top.cuizilin.study.connector;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ResponseWriter extends PrintWriter {
    public ResponseWriter(OutputStreamWriter writer) {
        super(writer);
    }

    public void print(boolean b) {
        super.print(b);
    }

    public void print(char c) {
        super.print(c);
    }

    public void print(char ca[]) {
        super.print(ca);
    }

    public void print(double d) {
        super.print(d);
    }

    public void print(float f) {
        super.print(f);
    }

    public void print(int i) {
        super.print(i);
    }

    public void print(long l) {
        super.print(l);
    }

    public void print(Object o) {
        super.print(o);
    }

    public void print(String s) {
        super.print(s);
    }

    public void println() {
        super.println();
    }

    public void println(boolean b) {
        super.println(b);
    }

    public void println(char c) {
        super.println(c);
    }

    public void println(char ca[]) {
        super.println(ca);
    }

    public void println(double d) {
        super.println(d);
    }

    public void println(float f) {
        super.println(f);
    }

    public void println(int i) {
        super.println(i);
    }

    public void println(long l) {
        super.println(l);
    }

    public void println(Object o) {
        super.println(o);
        super.flush();
    }

    public void println(String s) {
        super.println(s);
        super.flush();
    }

    public void write(char c) {
        super.write(c);
        super.flush();
    }

    public void write(char ca[]) {
        super.write(ca);
        super.flush();
    }

    public void write(char ca[], int off, int len) {
        super.write(ca, off, len);
        super.flush();
    }

    public void write(String s) {
        super.write(s);
        super.flush();
    }

    public void write(String s, int off, int len) {
        super.write(s, off, len);
        super.flush();
    }
}
