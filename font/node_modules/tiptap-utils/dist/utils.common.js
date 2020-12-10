
    /*!
    * tiptap-utils v1.10.4
    * (c) 2020 überdosis GbR (limited liability)
    * @license MIT
    */
  
'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var prosemirrorUtils = require('prosemirror-utils');

function getMarkAttrs(state, type) {
  const {
    from,
    to
  } = state.selection;
  let marks = [];
  state.doc.nodesBetween(from, to, node => {
    marks = [...marks, ...node.marks];
  });
  const mark = marks.find(markItem => markItem.type.name === type.name);

  if (mark) {
    return mark.attrs;
  }

  return {};
}

function getNodeAttrs(state, type) {
  const {
    from,
    to
  } = state.selection;
  let nodes = [];
  state.doc.nodesBetween(from, to, node => {
    nodes = [...nodes, node];
  });
  const node = nodes.reverse().find(nodeItem => nodeItem.type.name === type.name);

  if (node) {
    return node.attrs;
  }

  return {};
}

function getMarkRange($pos = null, type = null) {
  if (!$pos || !type) {
    return false;
  }

  const start = $pos.parent.childAfter($pos.parentOffset);

  if (!start.node) {
    return false;
  }

  const link = start.node.marks.find(mark => mark.type === type);

  if (!link) {
    return false;
  }

  let startIndex = $pos.index();
  let startPos = $pos.start() + start.offset;
  let endIndex = startIndex + 1;
  let endPos = startPos + start.node.nodeSize;

  while (startIndex > 0 && link.isInSet($pos.parent.child(startIndex - 1).marks)) {
    startIndex -= 1;
    startPos -= $pos.parent.child(startIndex).nodeSize;
  }

  while (endIndex < $pos.parent.childCount && link.isInSet($pos.parent.child(endIndex).marks)) {
    endPos += $pos.parent.child(endIndex).nodeSize;
    endIndex += 1;
  }

  return {
    from: startPos,
    to: endPos
  };
}

function markIsActive(state, type) {
  const {
    from,
    $from,
    to,
    empty
  } = state.selection;

  if (empty) {
    return !!type.isInSet(state.storedMarks || $from.marks());
  }

  return !!state.doc.rangeHasMark(from, to, type);
}

function nodeEqualsType({
  types,
  node
}) {
  return Array.isArray(types) && types.includes(node.type) || node.type === types;
}

function nodeIsActive(state, type, attrs = {}) {
  const predicate = node => node.type === type;

  const node = prosemirrorUtils.findSelectedNodeOfType(type)(state.selection) || prosemirrorUtils.findParentNode(predicate)(state.selection);

  if (!Object.keys(attrs).length || !node) {
    return !!node;
  }

  return node.node.hasMarkup(type, { ...node.node.attrs,
    ...attrs
  });
}

exports.getMarkAttrs = getMarkAttrs;
exports.getMarkRange = getMarkRange;
exports.getNodeAttrs = getNodeAttrs;
exports.markIsActive = markIsActive;
exports.nodeEqualsType = nodeEqualsType;
exports.nodeIsActive = nodeIsActive;
