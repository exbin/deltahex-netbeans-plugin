/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.framework.bined.options;

import java.awt.Font;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.bined.CodeAreaViewMode;
import org.exbin.bined.CodeCharactersCase;
import org.exbin.bined.CodeType;
import org.exbin.bined.PositionCodeType;
import org.exbin.bined.capability.CodeCharactersCaseCapable;
import org.exbin.bined.capability.CodeTypeCapable;
import org.exbin.bined.capability.RowWrappingCapable;
import org.exbin.bined.capability.RowWrappingCapable.RowWrappingMode;
import org.exbin.bined.capability.ViewModeCapable;
import org.exbin.bined.extended.capability.PositionCodeTypeCapable;
import org.exbin.bined.extended.capability.ShowUnprintablesCapable;
import org.exbin.bined.highlight.swing.extended.ExtendedHighlightNonAsciiCodeAreaPainter;
import org.exbin.bined.swing.capability.FontCapable;
import org.exbin.bined.swing.extended.ExtCodeArea;
import org.exbin.framework.bined.preferences.CodeAreaParameters;

/**
 * Code area options.
 *
 * @version 0.2.0 2019/03/02
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class CodeAreaOptions {

    private Font codeFont = null;
    private boolean rowWrapping = false;
    private CodeType codeType = CodeType.HEXADECIMAL;
    private boolean showUnprintables = true;
    private CodeCharactersCase codeCharactersCase = CodeCharactersCase.UPPER;
    private PositionCodeType positionCodeType = PositionCodeType.HEXADECIMAL;
    private CodeAreaViewMode viewMode = CodeAreaViewMode.DUAL;
    private boolean codeColorization = true;
    private boolean useDefaultFont = true;

    public static final Font DEFAULT_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 12);

    @Nonnull
    public Font getCodeFont() {
        return codeFont;
    }

    public void setCodeFont(Font codeFont) {
        this.codeFont = codeFont;
    }

    public boolean isRowWrapping() {
        return rowWrapping;
    }

    public void setRowWrapping(boolean rowWrapping) {
        this.rowWrapping = rowWrapping;
    }

    @Nonnull
    public CodeType getCodeType() {
        return codeType;
    }

    public void setCodeType(CodeType codeType) {
        this.codeType = codeType;
    }

    public boolean isShowUnprintables() {
        return showUnprintables;
    }

    public void setShowUnprintables(boolean showUnprintables) {
        this.showUnprintables = showUnprintables;
    }

    @Nonnull
    public CodeCharactersCase getCodeCharactersCase() {
        return codeCharactersCase;
    }

    public void setCodeCharactersCase(CodeCharactersCase codeCharactersCase) {
        this.codeCharactersCase = codeCharactersCase;
    }

    @Nonnull
    public PositionCodeType getPositionCodeType() {
        return positionCodeType;
    }

    public void setPositionCodeType(PositionCodeType positionCodeType) {
        this.positionCodeType = positionCodeType;
    }

    @Nonnull
    public CodeAreaViewMode getViewMode() {
        return viewMode;
    }

    public void setViewMode(CodeAreaViewMode viewMode) {
        this.viewMode = viewMode;
    }

    public boolean isCodeColorization() {
        return codeColorization;
    }

    public void setCodeColorization(boolean codeColorization) {
        this.codeColorization = codeColorization;
    }

    public boolean isUseDefaultFont() {
        return useDefaultFont;
    }

    public void setUseDefaultFont(boolean useDefaultFont) {
        this.useDefaultFont = useDefaultFont;
    }

    public void loadFromParameters(CodeAreaParameters parameters) {
        codeFont = parameters.getCodeFont(DEFAULT_FONT);
        rowWrapping = parameters.isRowWrapping();
        codeType = parameters.getCodeType();
        showUnprintables = parameters.isShowNonprintables();
        codeCharactersCase = parameters.getCodeCharactersCase();
        positionCodeType = parameters.getPositionCodeType();
        viewMode = parameters.getViewMode();
        codeColorization = parameters.isCodeColorization();
        useDefaultFont = parameters.isUseDefaultFont();
    }

    public void saveToParameters(CodeAreaParameters parameters) {
        parameters.setCodeFont(codeFont);
        parameters.setRowWrapping(rowWrapping);
        parameters.setCodeType(codeType);
        parameters.setShowUnprintables(showUnprintables);
        parameters.setCodeCharactersCase(codeCharactersCase);
        parameters.setPositionCodeType(positionCodeType);
        parameters.setViewMode(viewMode);
        parameters.setCodeColorization(codeColorization);
        parameters.setUseDefaultFont(useDefaultFont);
    }

    public void applyFromCodeArea(ExtCodeArea codeArea) {
        codeFont = ((FontCapable) codeArea).getCodeFont();
        rowWrapping = ((RowWrappingCapable) codeArea).getRowWrapping() == RowWrappingMode.WRAPPING;
        codeType = ((CodeTypeCapable) codeArea).getCodeType();
        showUnprintables = ((ShowUnprintablesCapable) codeArea).isShowUnprintables();
        codeCharactersCase = ((CodeCharactersCaseCapable) codeArea).getCodeCharactersCase();
        positionCodeType = ((PositionCodeTypeCapable) codeArea).getPositionCodeType();
        viewMode = ((ViewModeCapable) codeArea).getViewMode();
        codeColorization = ((ExtendedHighlightNonAsciiCodeAreaPainter) codeArea.getPainter()).isNonAsciiHighlightingEnabled();
    }

    public void applyToCodeArea(ExtCodeArea codeArea) {
        ((FontCapable) codeArea).setCodeFont(useDefaultFont ? DEFAULT_FONT : codeFont);
        ((RowWrappingCapable) codeArea).setRowWrapping(rowWrapping ? RowWrappingMode.WRAPPING : RowWrappingMode.NO_WRAPPING);
        ((CodeTypeCapable) codeArea).setCodeType(codeType);
        ((ShowUnprintablesCapable) codeArea).setShowUnprintables(showUnprintables);
        ((CodeCharactersCaseCapable) codeArea).setCodeCharactersCase(codeCharactersCase);
        ((PositionCodeTypeCapable) codeArea).setPositionCodeType(positionCodeType);
        ((ViewModeCapable) codeArea).setViewMode(viewMode);
        ((ExtendedHighlightNonAsciiCodeAreaPainter) codeArea.getPainter()).setNonAsciiHighlightingEnabled(codeColorization);
    }
}