/* The following code was generated by JFlex 1.6.1 */

/************************************************************************************************/
/* i-Code CNES is a static code analyzer.                                                       */
/* This software is a free software, under the terms of the Eclipse Public License version 1.0. */ 
/* http://www.eclipse.org/legal/epl-v10.html                                                    */
/************************************************************************************************/ 

/*****************************************************************************/
/* This file is used to generate a rule checker for F90.INST.Nullify rule.	 */
/* For further information on this, we advise you to refer to RNC manuals.	 */
/* As many comments have been done on the ExampleRule.lex file, this file    */
/* will restrain its comments on modifications.								 */
/*																			 */
/*****************************************************************************/

package fr.cnes.analysis.tools.fortran90.rules;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

import java.util.List;

import org.eclipse.core.runtime.IPath;

import fr.cnes.analysis.tools.analyzer.exception.JFlexException;
import fr.cnes.analysis.tools.analyzer.datas.AbstractRule;
import fr.cnes.analysis.tools.analyzer.datas.Violation;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>lex/F90INSTNullify.lex</tt>
 */
public class F90INSTNullify extends AbstractRule {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int COMMENT = 2;
  public static final int NAMING = 4;
  public static final int NEW_LINE = 6;
  public static final int LINE = 8;
  public static final int DEALLOC = 10;
  public static final int SET_NULL = 12;
  public static final int NULL_VAR = 14;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  3,  3,  4,  4,  3,  3,  5, 5
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\26\1\35\1\37\1\40\1\36\22\0\1\26\1\1\1\32"+
    "\2\0\1\30\1\0\1\31\1\33\7\0\12\23\7\0\1\20\1\16"+
    "\1\5\1\14\1\13\1\2\1\17\1\27\1\24\2\27\1\22\1\21"+
    "\1\4\1\10\1\11\1\27\1\12\1\25\1\6\1\3\3\27\1\34"+
    "\1\27\4\0\1\23\1\0\1\20\1\16\1\5\1\14\1\13\1\2"+
    "\1\17\1\27\1\24\2\27\1\22\1\21\1\4\1\10\1\11\1\27"+
    "\1\12\1\25\1\6\1\3\3\27\1\34\1\27\12\0\1\37\252\0"+
    "\2\7\115\0\1\15\u1ea8\0\1\37\1\37\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\6\0\1\1\1\2\2\3\1\1\1\3\1\1\1\3"+
    "\1\1\2\3\2\1\1\4\1\1\1\2\1\5\1\4"+
    "\1\6\1\7\1\10\1\11\3\0\3\3\1\0\1\3"+
    "\1\0\3\3\2\0\1\3\1\0\1\3\3\0\2\3"+
    "\16\0\2\3\1\0\1\3\1\0\3\3\1\0\1\3"+
    "\1\0\1\3\3\0\2\3\11\0\2\3\1\0\1\3"+
    "\1\0\3\3\1\0\2\3\1\0\1\3\3\0\2\3"+
    "\11\0\2\3\1\0\2\3\1\0\3\3\1\0\2\3"+
    "\1\0\1\3\4\0\2\3\11\0\1\3\1\0\1\3"+
    "\1\0\2\3\1\0\3\3\1\0\2\3\1\0\1\12"+
    "\4\0\2\3\12\0\1\3\1\0\1\3\1\0\2\3"+
    "\1\0\1\1\2\3\1\0\1\3\1\0\1\1\2\0"+
    "\1\1\2\3\12\0\1\3\1\12\1\0\1\3\1\0"+
    "\2\3\3\0\1\3\6\0\1\13\3\0\1\3\1\13"+
    "\2\0\1\13\16\0\1\14\1\0\1\14\1\0\1\14"+
    "\15\0\2\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[266];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\41\0\102\0\143\0\204\0\245\0\306\0\306"+
    "\0\347\0\u0108\0\u0129\0\u014a\0\u016b\0\u018c\0\u01ad\0\u01ce"+
    "\0\u01ef\0\u0210\0\u0231\0\306\0\u0252\0\u0252\0\u0252\0\u0252"+
    "\0\u0273\0\u0294\0\u0252\0\u02b5\0\u02d6\0\u02f7\0\u0318\0\u0339"+
    "\0\u035a\0\u037b\0\u039c\0\u03bd\0\u03de\0\u03ff\0\u0420\0\u0441"+
    "\0\u0462\0\u0483\0\u04a4\0\u04c5\0\u04e6\0\u0507\0\u0528\0\u0549"+
    "\0\u056a\0\u058b\0\u05ac\0\u05cd\0\u05ee\0\u060f\0\u0630\0\u0651"+
    "\0\u0672\0\u0693\0\u06b4\0\u06d5\0\u06f6\0\u0717\0\u0738\0\u0759"+
    "\0\u077a\0\u079b\0\u07bc\0\u07dd\0\u07fe\0\u081f\0\u0840\0\u0861"+
    "\0\u0882\0\u08a3\0\u08c4\0\u08e5\0\u0906\0\u0927\0\u0948\0\u0969"+
    "\0\u098a\0\u09ab\0\u09cc\0\u09ed\0\u0a0e\0\u0a2f\0\u0a50\0\u0a71"+
    "\0\u0a92\0\u0ab3\0\u0ad4\0\u0af5\0\u0b16\0\u0b37\0\u0b58\0\u0b79"+
    "\0\u0b9a\0\u0bbb\0\u0bdc\0\u0bfd\0\u0c1e\0\u0c3f\0\u0c60\0\u0c81"+
    "\0\u0ca2\0\u0cc3\0\u0ce4\0\u0d05\0\u0d26\0\u0d47\0\u0d68\0\u0d89"+
    "\0\u0daa\0\u0dcb\0\u0dec\0\u0e0d\0\u0e2e\0\u0e4f\0\u0e70\0\u0e91"+
    "\0\u0eb2\0\u0ed3\0\u0ef4\0\u0f15\0\u0f36\0\u0f57\0\u0f78\0\u0f99"+
    "\0\u0fba\0\u0fdb\0\u0ffc\0\u101d\0\u103e\0\u105f\0\u1080\0\u10a1"+
    "\0\u10c2\0\u10e3\0\u1104\0\u1125\0\u1146\0\u1167\0\u1188\0\u11a9"+
    "\0\u11ca\0\u11eb\0\u120c\0\u122d\0\u124e\0\u126f\0\u1290\0\u12b1"+
    "\0\u12d2\0\u12f3\0\u1314\0\u1335\0\u1356\0\u1377\0\u1398\0\u13b9"+
    "\0\u13da\0\u13fb\0\u141c\0\u143d\0\u145e\0\u147f\0\u14a0\0\u14c1"+
    "\0\u14e2\0\u1503\0\u1524\0\u1545\0\u1566\0\u1587\0\u15a8\0\u15c9"+
    "\0\u15ea\0\u160b\0\u162c\0\u164d\0\u166e\0\u168f\0\u16b0\0\u16d1"+
    "\0\u13da\0\u16f2\0\u1713\0\u1734\0\u1755\0\u1776\0\u037b\0\u1797"+
    "\0\u17b8\0\u17d9\0\u17fa\0\u181b\0\u183c\0\u185d\0\u187e\0\u189f"+
    "\0\u18c0\0\u18e1\0\u1902\0\u1923\0\u1944\0\u1965\0\u1986\0\u17d9"+
    "\0\u19a7\0\u19c8\0\u19e9\0\u1a0a\0\u1a2b\0\u1a4c\0\u1a6d\0\u1a8e"+
    "\0\u1aaf\0\u1ad0\0\u1af1\0\u1b12\0\u1b33\0\u1b54\0\u1b75\0\u0252"+
    "\0\u1b96\0\u1bb7\0\u1bd8\0\u1bf9\0\u05ac\0\u1c1a\0\u1c3b\0\u0630"+
    "\0\u1c5c\0\u1c7d\0\u1c9e\0\u1cbf\0\u1ce0\0\u1d01\0\u1d22\0\u1d43"+
    "\0\u1d64\0\u1d85\0\u1da6\0\u1dc7\0\u1de8\0\u1e09\0\u0252\0\u1e2a"+
    "\0\u05ac\0\u1e4b\0\u0630\0\u1e6c\0\u1e8d\0\u1eae\0\u1ecf\0\u1ef0"+
    "\0\u1f11\0\u1f32\0\u1f53\0\u1f74\0\u1f95\0\u1fb6\0\u1fd7\0\u1ff8"+
    "\0\u05ac\0\u0630";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[266];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\7\1\10\1\11\4\12\1\13\1\12\1\14\3\12"+
    "\1\15\3\12\1\16\1\12\1\17\1\20\1\21\1\7"+
    "\1\12\1\7\1\22\1\23\1\7\1\12\1\7\3\24"+
    "\1\25\1\26\33\25\2\27\2\30\1\25\1\26\5\31"+
    "\1\25\5\31\1\25\5\31\1\25\2\31\1\25\1\31"+
    "\4\25\1\31\2\27\3\30\1\26\37\30\1\25\1\26"+
    "\5\32\1\25\5\32\1\25\5\32\1\25\2\32\1\25"+
    "\1\32\4\25\1\32\1\33\3\30\1\25\1\26\5\34"+
    "\1\25\5\34\1\25\5\34\1\25\2\34\1\25\1\34"+
    "\4\25\1\34\1\27\3\30\4\0\1\35\7\0\1\36"+
    "\4\0\1\37\21\0\1\40\1\41\3\42\1\43\1\42"+
    "\1\44\3\42\1\45\3\42\1\46\2\42\1\47\1\50"+
    "\1\0\1\42\1\51\3\0\1\42\6\0\1\40\4\42"+
    "\1\43\1\42\1\44\3\42\1\45\3\42\1\46\2\42"+
    "\1\47\1\50\1\0\1\42\1\51\3\0\1\42\10\0"+
    "\1\52\7\0\1\36\4\0\1\37\21\0\1\40\4\42"+
    "\1\43\1\42\1\44\1\53\2\42\1\45\3\42\1\46"+
    "\2\42\1\47\1\50\1\0\1\42\1\51\3\0\1\42"+
    "\7\0\1\54\1\35\7\0\1\36\4\0\1\37\21\0"+
    "\1\40\4\42\1\43\1\55\1\44\3\42\1\45\3\42"+
    "\1\46\2\42\1\47\1\50\1\0\1\42\1\51\3\0"+
    "\1\42\6\0\1\56\4\0\1\43\1\0\1\57\3\0"+
    "\1\45\3\0\1\60\2\0\1\43\1\45\15\0\1\40"+
    "\1\42\1\61\2\42\1\43\1\42\1\44\3\42\1\45"+
    "\3\42\1\46\2\42\1\47\1\50\1\0\1\42\1\51"+
    "\3\0\1\42\6\0\1\40\1\62\3\42\1\43\1\42"+
    "\1\44\3\42\1\45\3\42\1\46\2\42\1\47\1\50"+
    "\1\0\1\42\1\51\3\0\1\42\4\0\4\63\1\64"+
    "\7\63\1\65\4\63\1\66\7\63\1\25\7\63\4\67"+
    "\1\70\7\67\1\71\4\67\1\72\10\67\1\25\6\67"+
    "\43\0\5\31\1\0\5\31\1\0\10\31\1\0\1\31"+
    "\1\73\3\0\1\31\6\0\5\32\1\0\5\32\1\0"+
    "\10\32\1\0\1\32\1\74\3\0\1\32\6\0\5\34"+
    "\1\0\5\34\1\0\10\34\1\0\1\34\1\75\3\0"+
    "\1\34\7\0\1\76\50\0\1\77\35\0\1\100\32\0"+
    "\1\42\1\101\3\42\1\0\5\42\1\0\10\42\1\0"+
    "\1\42\1\51\3\0\1\42\6\0\2\42\1\102\2\42"+
    "\1\0\5\42\1\0\10\42\1\0\1\42\1\51\3\0"+
    "\1\42\6\0\5\42\1\0\5\42\1\0\10\42\1\0"+
    "\1\42\1\51\3\0\1\42\10\0\1\103\36\0\5\42"+
    "\1\0\2\42\1\104\2\42\1\0\10\42\1\0\1\42"+
    "\1\51\3\0\1\42\7\0\1\105\37\0\5\42\1\0"+
    "\1\106\4\42\1\0\10\42\1\0\1\42\1\51\3\0"+
    "\1\42\6\0\2\42\1\107\2\42\1\0\5\42\1\0"+
    "\10\42\1\0\1\42\1\51\3\0\1\42\6\0\1\42"+
    "\1\110\3\42\1\0\5\42\1\0\10\42\1\0\1\42"+
    "\1\51\3\0\1\42\6\0\5\42\1\0\5\42\1\0"+
    "\5\42\1\0\2\42\1\0\1\42\4\0\1\42\7\0"+
    "\1\76\2\0\1\111\34\0\5\42\1\0\1\112\4\42"+
    "\1\0\10\42\1\0\1\42\1\51\3\0\1\42\22\0"+
    "\1\113\24\0\5\42\1\0\4\42\1\114\1\0\10\42"+
    "\1\0\1\42\1\51\3\0\1\42\7\0\1\115\47\0"+
    "\1\116\36\0\1\117\32\0\4\42\1\120\1\0\5\42"+
    "\1\0\10\42\1\0\1\42\1\51\3\0\1\42\6\0"+
    "\5\42\1\0\5\42\1\0\1\121\7\42\1\0\1\42"+
    "\1\51\3\0\1\42\4\0\31\63\1\25\12\63\1\122"+
    "\25\63\1\25\22\63\1\123\15\63\1\25\17\63\1\124"+
    "\20\63\1\25\7\63\32\67\1\25\11\67\1\125\26\67"+
    "\1\25\21\67\1\126\16\67\1\25\16\67\1\127\21\67"+
    "\1\25\6\67\2\0\5\31\1\0\5\31\1\0\5\31"+
    "\1\0\2\31\1\0\1\31\4\0\1\31\6\0\5\32"+
    "\1\0\5\32\1\0\5\32\1\0\2\32\1\0\1\32"+
    "\4\0\1\32\6\0\5\34\1\0\5\34\1\0\5\34"+
    "\1\0\2\34\1\0\1\34\4\0\1\34\26\0\1\130"+
    "\36\0\1\131\34\0\1\132\26\0\2\42\1\133\2\42"+
    "\1\0\5\42\1\0\10\42\1\0\1\42\1\51\3\0"+
    "\1\42\6\0\3\42\1\134\1\42\1\0\5\42\1\0"+
    "\10\42\1\0\1\42\1\51\3\0\1\42\12\0\1\135"+
    "\34\0\5\42\1\0\1\136\4\42\1\0\10\42\1\0"+
    "\1\42\1\51\3\0\1\42\22\0\1\137\24\0\5\42"+
    "\1\0\4\42\1\140\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\6\0\4\42\1\141\1\0\5\42\1\0"+
    "\10\42\1\0\1\42\1\51\3\0\1\42\6\0\5\42"+
    "\1\0\5\42\1\0\1\142\7\42\1\0\1\42\1\51"+
    "\3\0\1\42\17\0\1\143\27\0\3\42\1\144\1\42"+
    "\1\0\5\42\1\0\1\42\1\145\6\42\1\0\1\42"+
    "\1\51\3\0\1\42\16\0\1\146\30\0\1\42\1\147"+
    "\3\42\1\0\5\42\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\10\0\1\150\44\0\1\151\44\0\1\152"+
    "\26\0\5\42\1\0\3\42\1\153\1\42\1\0\10\42"+
    "\1\0\1\42\1\51\3\0\1\42\6\0\5\42\1\0"+
    "\2\42\1\154\2\42\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\4\0\22\63\1\155\6\63\1\25\27\63"+
    "\1\156\10\63\1\25\23\63\1\157\14\63\1\25\7\63"+
    "\22\67\1\160\7\67\1\25\26\67\1\161\11\67\1\25"+
    "\22\67\1\162\15\67\1\25\6\67\22\0\1\163\40\0"+
    "\1\164\21\0\1\165\37\0\3\42\1\166\1\42\1\0"+
    "\5\42\1\0\10\42\1\0\1\42\1\51\3\0\1\42"+
    "\6\0\4\42\1\167\1\0\5\42\1\0\10\42\1\0"+
    "\1\42\1\51\3\0\1\42\17\0\1\170\27\0\3\42"+
    "\1\171\1\42\1\0\5\42\1\0\1\42\1\172\6\42"+
    "\1\0\1\42\1\51\3\0\1\42\16\0\1\173\30\0"+
    "\1\42\1\174\3\42\1\0\5\42\1\0\10\42\1\0"+
    "\1\42\1\51\3\0\1\42\6\0\5\42\1\0\3\42"+
    "\1\175\1\42\1\0\10\42\1\0\1\42\1\51\3\0"+
    "\1\42\6\0\5\42\1\0\2\42\1\176\2\42\1\0"+
    "\10\42\1\0\1\42\1\51\3\0\1\42\16\0\1\177"+
    "\30\0\5\42\1\0\3\42\1\200\1\42\1\0\10\42"+
    "\1\0\1\42\1\51\3\0\1\42\6\0\5\42\1\0"+
    "\2\42\1\201\2\42\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\14\0\1\202\32\0\5\42\1\0\5\42"+
    "\1\0\4\42\1\203\3\42\1\0\1\42\1\51\3\0"+
    "\1\42\11\0\1\204\40\0\1\205\11\0\1\206\24\0"+
    "\1\207\37\0\5\42\1\0\2\42\1\210\2\42\1\0"+
    "\10\42\1\0\1\42\1\51\3\0\1\42\6\0\5\42"+
    "\1\0\1\211\4\42\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\4\0\22\63\1\212\6\63\1\25\31\63"+
    "\1\213\6\63\1\25\12\63\1\214\25\63\1\25\7\63"+
    "\22\67\1\215\7\67\1\25\30\67\1\216\7\67\1\25"+
    "\11\67\1\217\26\67\1\25\6\67\7\0\1\220\14\0"+
    "\1\220\36\0\1\221\40\0\1\222\20\0\4\42\1\223"+
    "\1\0\5\42\1\0\10\42\1\0\1\42\1\51\3\0"+
    "\1\42\6\0\5\42\1\224\5\42\1\0\6\42\1\225"+
    "\1\42\1\0\1\42\1\51\3\0\1\42\16\0\1\226"+
    "\30\0\5\42\1\0\3\42\1\227\1\42\1\0\10\42"+
    "\1\0\1\42\1\51\3\0\1\42\6\0\5\42\1\0"+
    "\2\42\1\230\2\42\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\14\0\1\231\32\0\5\42\1\0\5\42"+
    "\1\0\4\42\1\232\3\42\1\0\1\42\1\51\3\0"+
    "\1\42\6\0\5\42\1\0\2\42\1\233\2\42\1\0"+
    "\10\42\1\0\1\42\1\51\3\0\1\42\6\0\5\42"+
    "\1\0\1\234\4\42\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\6\0\1\235\40\0\5\42\1\0\4\42"+
    "\1\236\1\0\10\42\1\0\1\42\1\51\3\0\1\42"+
    "\6\0\5\42\1\0\5\42\1\0\2\42\1\237\5\42"+
    "\1\0\1\42\1\51\3\0\1\42\7\0\1\240\37\0"+
    "\5\42\1\0\3\42\1\241\1\42\1\0\10\42\1\0"+
    "\1\42\1\51\3\0\1\42\12\0\1\242\45\0\1\243"+
    "\37\0\1\244\50\0\1\245\20\0\1\246\4\42\1\0"+
    "\5\42\1\0\10\42\1\0\1\42\1\51\3\0\1\42"+
    "\6\0\1\42\1\247\3\42\1\0\5\42\1\0\10\42"+
    "\1\0\1\42\1\51\3\0\1\42\4\0\7\63\1\250"+
    "\14\63\1\250\4\63\1\25\31\63\1\251\6\63\1\25"+
    "\31\63\1\252\6\63\1\25\7\63\7\67\1\253\14\67"+
    "\1\253\5\67\1\25\30\67\1\254\7\67\1\25\30\67"+
    "\1\255\7\67\1\25\6\67\2\0\1\256\46\0\1\257"+
    "\43\0\1\260\27\0\5\42\1\261\5\42\1\0\6\42"+
    "\1\262\1\42\1\0\1\42\1\51\3\0\1\42\14\0"+
    "\1\263\32\0\5\42\1\0\1\264\4\42\1\0\10\42"+
    "\1\0\1\42\1\51\3\0\1\42\6\0\1\265\40\0"+
    "\5\42\1\0\4\42\1\266\1\0\10\42\1\0\1\42"+
    "\1\51\3\0\1\42\6\0\5\42\1\0\5\42\1\0"+
    "\2\42\1\267\5\42\1\0\1\42\1\51\3\0\1\42"+
    "\7\0\1\270\37\0\5\42\1\0\3\42\1\271\1\42"+
    "\1\0\10\42\1\0\1\42\1\51\3\0\1\42\6\0"+
    "\1\272\4\42\1\0\5\42\1\0\10\42\1\0\1\42"+
    "\1\51\3\0\1\42\6\0\1\42\1\273\3\42\1\0"+
    "\5\42\1\0\10\42\1\0\1\42\1\51\3\0\1\42"+
    "\24\0\1\274\22\0\1\42\1\275\3\42\1\0\5\42"+
    "\1\0\10\42\1\0\1\42\1\51\3\0\1\42\6\0"+
    "\5\42\1\0\5\42\1\0\3\42\1\241\4\42\1\0"+
    "\1\42\1\51\3\0\1\42\12\0\1\276\34\0\5\277"+
    "\1\0\5\277\1\0\10\277\1\0\1\277\1\51\3\0"+
    "\1\277\13\0\1\261\14\0\1\261\30\0\1\300\44\0"+
    "\1\301\33\0\1\302\27\0\5\42\1\0\5\42\1\0"+
    "\2\42\1\303\5\42\1\0\1\42\1\51\3\0\1\42"+
    "\6\0\4\42\1\304\1\0\5\42\1\0\10\42\1\0"+
    "\1\42\1\51\3\0\1\42\4\0\2\63\1\305\26\63"+
    "\1\25\17\63\1\306\20\63\1\25\22\63\1\307\15\63"+
    "\1\25\7\63\2\67\1\310\27\67\1\25\16\67\1\311"+
    "\21\67\1\25\21\67\1\312\16\67\1\25\6\67\34\0"+
    "\1\313\11\0\1\314\44\0\1\315\14\0\1\260\11\0"+
    "\1\260\10\0\1\316\32\0\5\42\1\0\1\317\4\42"+
    "\1\0\10\42\1\0\1\42\1\51\3\0\1\42\10\0"+
    "\1\320\36\0\2\42\1\241\2\42\1\0\5\42\1\0"+
    "\10\42\1\0\1\42\1\51\3\0\1\42\24\0\1\321"+
    "\22\0\1\42\1\322\3\42\1\0\5\42\1\0\10\42"+
    "\1\0\1\42\1\51\3\0\1\42\6\0\5\42\1\0"+
    "\5\42\1\0\3\42\1\271\4\42\1\0\1\42\1\51"+
    "\3\0\1\42\12\0\1\323\34\0\5\42\1\0\5\42"+
    "\1\0\2\42\1\324\5\42\1\0\1\42\1\51\3\0"+
    "\1\42\6\0\4\42\1\325\1\0\5\42\1\0\10\42"+
    "\1\0\1\42\1\51\3\0\1\42\11\0\1\326\35\0"+
    "\5\42\1\0\2\42\1\203\2\42\1\0\10\42\1\0"+
    "\1\42\1\51\3\0\1\42\13\0\1\327\14\0\1\327"+
    "\17\0\1\330\56\0\1\302\21\0\5\25\1\0\5\25"+
    "\1\0\10\25\1\0\1\25\4\0\1\25\6\0\3\42"+
    "\1\203\1\42\1\0\5\42\1\0\10\42\1\0\1\42"+
    "\1\51\3\0\1\42\6\0\5\42\1\327\5\42\1\0"+
    "\6\42\1\331\1\42\1\0\1\42\1\51\3\0\1\42"+
    "\4\0\31\63\1\25\2\63\1\332\11\63\1\333\23\63"+
    "\1\25\20\63\1\334\14\63\1\307\2\63\1\25\6\63"+
    "\1\307\32\67\1\25\1\67\1\335\11\67\1\336\24\67"+
    "\1\25\17\67\1\337\14\67\1\312\3\67\1\25\5\67"+
    "\1\312\26\0\1\313\4\0\1\340\4\0\1\313\20\0"+
    "\1\341\32\0\1\342\32\0\1\302\36\0\2\42\1\271"+
    "\2\42\1\0\5\42\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\11\0\1\245\35\0\5\42\1\0\2\42"+
    "\1\232\2\42\1\0\10\42\1\0\1\42\1\51\3\0"+
    "\1\42\13\0\1\343\14\0\1\343\16\0\3\42\1\232"+
    "\1\42\1\0\5\42\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\6\0\5\42\1\343\5\42\1\0\6\42"+
    "\1\344\1\42\1\0\1\42\1\51\3\0\1\42\17\0"+
    "\1\320\31\0\1\326\46\0\1\245\30\0\2\42\1\203"+
    "\2\42\1\0\5\42\1\0\10\42\1\0\1\42\1\51"+
    "\3\0\1\42\4\0\26\63\1\332\2\63\1\25\1\63"+
    "\1\345\4\63\1\332\20\63\1\346\10\63\1\25\21\63"+
    "\1\347\16\63\1\25\7\63\26\67\1\335\3\67\1\25"+
    "\1\350\4\67\1\335\20\67\1\351\11\67\1\25\20\67"+
    "\1\352\17\67\1\25\6\67\6\0\1\353\42\0\1\354"+
    "\34\0\1\245\36\0\2\42\1\232\2\42\1\0\5\42"+
    "\1\0\10\42\1\0\1\42\1\51\3\0\1\42\4\0"+
    "\6\63\1\355\22\63\1\25\17\63\1\356\20\63\1\25"+
    "\7\63\6\67\1\357\23\67\1\25\16\67\1\360\21\67"+
    "\1\25\6\67\13\0\1\361\32\0\1\362\33\0\13\63"+
    "\1\363\15\63\1\25\14\63\1\364\23\63\1\25\7\63"+
    "\13\67\1\365\16\67\1\25\13\67\1\366\24\67\1\25"+
    "\6\67\26\0\1\361\4\0\1\367\4\0\1\361\13\0"+
    "\1\370\25\0\26\63\1\363\2\63\1\25\1\63\1\371"+
    "\4\63\1\363\13\63\1\372\15\63\1\25\7\63\26\67"+
    "\1\365\3\67\1\25\1\373\4\67\1\365\13\67\1\374"+
    "\16\67\1\25\6\67\14\0\1\375\24\0\14\63\1\376"+
    "\14\63\1\25\7\63\14\67\1\377\15\67\1\25\6\67"+
    "\3\0\1\u0100\35\0\3\63\1\u0101\25\63\1\25\7\63"+
    "\3\67\1\u0102\26\67\1\25\6\67\12\0\1\u0103\26\0"+
    "\12\63\1\u0104\16\63\1\25\7\63\12\67\1\u0105\17\67"+
    "\1\25\6\67\13\0\1\u0106\25\0\13\63\1\u0107\15\63"+
    "\1\25\7\63\13\67\1\u0108\16\67\1\25\6\67\2\25"+
    "\5\0\1\25\5\0\1\25\10\0\1\25\1\0\4\25"+
    "\1\0\4\25\2\u0109\5\63\1\u0109\5\63\1\u0109\10\63"+
    "\1\u0109\1\63\1\u0109\1\25\2\u0109\1\63\4\u0109\2\u010a"+
    "\5\67\1\u010a\5\67\1\u010a\10\67\1\u010a\1\67\2\u010a"+
    "\1\25\1\u010a\1\67\4\u010a";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8217];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\6\0\16\1\4\11\2\1\1\11\1\1\3\0\3\1"+
    "\1\0\1\1\1\0\3\1\2\0\1\1\1\0\1\1"+
    "\3\0\2\1\16\0\2\1\1\0\1\1\1\0\3\1"+
    "\1\0\1\1\1\0\1\1\3\0\2\1\11\0\2\1"+
    "\1\0\1\1\1\0\3\1\1\0\2\1\1\0\1\1"+
    "\3\0\2\1\11\0\2\1\1\0\2\1\1\0\3\1"+
    "\1\0\2\1\1\0\1\1\4\0\2\1\11\0\1\1"+
    "\1\0\1\1\1\0\2\1\1\0\3\1\1\0\2\1"+
    "\1\0\1\1\4\0\2\1\12\0\1\1\1\0\1\1"+
    "\1\0\2\1\1\0\3\1\1\0\1\1\1\0\1\1"+
    "\2\0\3\1\12\0\2\1\1\0\1\1\1\0\2\1"+
    "\3\0\1\1\6\0\1\11\3\0\2\1\2\0\1\1"+
    "\16\0\1\11\1\0\1\1\1\0\1\1\15\0\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[266];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
	/** Variable used to store violation location and variable involved. **/
	String location = "MAIN PROGRAM";
	/** Variable used to store file value and function values associated. **/
	List<String> pointers = new LinkedList<String>(); 
	List<Integer> lines = new LinkedList<Integer>();
	int errorLine = 0;
	boolean isPointer = false;
	
	public F90INSTNullify() {
    }
	
	@Override
	public void setInputFile(IPath file) throws FileNotFoundException {
		super.setInputFile(file);
		this.zzReader = new FileReader(file.toOSString());
	}
	
	
	
	private void raiseRemainingErrors() throws JFlexException{
		for (int i = 0; i < pointers.size(); i++){
			setError(location,"It misses the instruction NULLIFY after the DEALLOCATION of" + pointers.get(i), lines.get(i));
		}
		pointers.clear();
		lines.clear();
	}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public F90INSTNullify(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 186) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public List<Violation> run() throws java.io.IOException, JFlexException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
          { 	raiseRemainingErrors();
	 
	return getViolations();
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { 
            }
          case 13: break;
          case 2: 
            { yybegin(COMMENT);
            }
          case 14: break;
          case 3: 
            { if(pointers.contains(yytext())) {
								setError(location,"It misses the instruction NULLIFY after the DEALLOCATION of " + yytext(), lines.get(pointers.indexOf(yytext())));
								lines.remove(pointers.indexOf(yytext()));
								pointers.remove(yytext());
							 }
            }
          case 15: break;
          case 4: 
            { throw new JFlexException( new Exception("Illegal character <" + yytext() + ">") );
            }
          case 16: break;
          case 5: 
            { yybegin(YYINITIAL);
            }
          case 17: break;
          case 6: 
            { location = location + " " + yytext(); 
							 yybegin(COMMENT);
            }
          case 18: break;
          case 7: 
            { if(!isPointer) { 
								pointers.add(yytext()); 
								lines.add(errorLine);
								isPointer = true; 
							 }
            }
          case 19: break;
          case 8: 
            { isPointer = false; yybegin(YYINITIAL);
            }
          case 20: break;
          case 9: 
            { if(pointers.contains(yytext())) {
								lines.remove(pointers.indexOf(yytext()));
								pointers.remove(yytext());
							 }
            }
          case 21: break;
          case 10: 
            { raiseRemainingErrors();
							 location = yytext(); 
							 yybegin(NAMING);
            }
          case 22: break;
          case 11: 
            { yybegin(NULL_VAR);
            }
          case 23: break;
          case 12: 
            { errorLine = yyline + 1; yybegin(DEALLOC);
            }
          case 24: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
